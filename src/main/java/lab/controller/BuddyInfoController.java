package lab.controller;

import lab.repository.BuddyInfoRepository;
import lab.model.BuddyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/buddyInfo")
public class BuddyInfoController {

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @PostMapping
    public BuddyInfo createBuddyInfo(@RequestBody BuddyInfo buddyInfo)
    {
        return buddyInfoRepository.save(buddyInfo);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public BuddyInfo getBuddyInfo(@PathVariable("id") Long id)
    {
        return buddyInfoRepository.findOne(id);
    }

    @GetMapping
    public Iterable<BuddyInfo> getAllBuddies()
    {
        return buddyInfoRepository.findAll();
    }

}
