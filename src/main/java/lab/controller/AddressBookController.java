package lab.controller;

import lab.repository.AddressBookRepository;
import lab.repository.BuddyInfoRepository;
import lab.model.AddressBook;
import lab.model.BuddyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressBook")
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @PostMapping
    public AddressBook createAddressBook()
    {
        return addressBookRepository.save(new AddressBook());
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

    @RequestMapping(value = "/{addressBookId}/buddies/{buddyId}", method = RequestMethod.PUT)
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

    @RequestMapping(value = "/{addressBookId}/buddies/{buddyId}", method = RequestMethod.DELETE)
    public ResponseEntity<AddressBook> deleteBuddy(@PathVariable("addressBookId") Long addressBookId, @PathVariable("buddyId") Long buddyId)
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
