package lab.controller;

import lab.repository.AddressBookRepository;
import lab.repository.BuddyInfoRepository;
import lab.model.AddressBook;
import lab.model.BuddyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class AddressBookController {

    private AddressBookRepository addressBookRepository;

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @Autowired
    public AddressBookController(AddressBookRepository addressBookRepository){
        this.addressBookRepository = addressBookRepository;
        this.createAddressBook();
    }


    @PostMapping
    public AddressBook createAddressBook()
    {
        return addressBookRepository.save(new AddressBook());
    }

    public AddressBook getBookGivenId(@PathVariable("id") Long id)
    {
        return addressBookRepository.findOne(id);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public AddressBook getAddressBook(@PathVariable("id") Long id)
    {
        return addressBookRepository.findOne(id);
    }

    @GetMapping
    public Iterable<AddressBook> getAllAddressBooks()
    {
        return addressBookRepository.findAll();
    }

    @RequestMapping(value = "/{bookId}/buddies/{buddyId}", method = RequestMethod.PUT)
    public ResponseEntity<AddressBook> addBuddy(@PathVariable("addressBookId") Long addressBookId, @PathVariable("buddyId") Long buddyId)
    {
        AddressBook addressBook = addressBookRepository.findOne(addressBookId);
        BuddyInfo buddyInfo = buddyInfoRepository.findOne(buddyId);
        if(addressBook != null && buddyInfo != null)
        {
            addressBook.addBuddy(buddyInfo);
            return ResponseEntity.ok().body(addressBookRepository.save(addressBook));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/{bookId}/add")
    public ResponseEntity<BuddyInfo> createBuddyInfo(@PathVariable("bookId") Long addressBookId,@RequestBody BuddyInfo buddyInfo)
    {
        AddressBook addressBook = addressBookRepository.findOne(addressBookId);
        if(addressBook != null && buddyInfo != null)
        {
            addressBook.addBuddy(buddyInfo);
            buddyInfoRepository.save(buddyInfo);
            return ResponseEntity.ok().body(buddyInfo);
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/{bookId}/buddies/{buddyId}", method = RequestMethod.DELETE)
    public ResponseEntity<AddressBook> deleteBuddy(@PathVariable("bookId") Long addressBookId, @PathVariable("buddyId") Long buddyId)
    {
        AddressBook addressBook = addressBookRepository.findOne(addressBookId);
        BuddyInfo buddyInfo = buddyInfoRepository.findOne(buddyId);
        if(addressBook != null && buddyInfo != null)
        {
            addressBook.removeBuddy(buddyInfo);
            return ResponseEntity.ok().body(addressBookRepository.save(addressBook));
        }
        return ResponseEntity.badRequest().build();
    }


}
