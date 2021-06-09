package mmj.evoting;

import mmj.evoting.contract.*;
import mmj.evoting.model.Vote;
import mmj.evoting.model.Voter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class EVoteControl {
    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);


    Web3j web3j;
    Credentials credentials;
    Evoting evoting;
    String contractAddress;


    @PostMapping(path = "/vote/init", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity initializeVote(@RequestBody Vote vote) throws Exception {
        web3j = Web3j.build(new HttpService("http://localhost:7545"));
        System.out.println(web3j.web3ClientVersion().send().getWeb3ClientVersion());
        credentials = Credentials.create("5dc010c86da592d7e09e4a55264841da44646a04b545b58c9312bb22f353818b");
        System.out.println(credentials);
        contractAddress = Evoting.deploy(web3j, credentials, GAS_PRICE, GAS_LIMIT).send().getContractAddress();
        System.out.println(contractAddress);
        evoting = Evoting.load(contractAddress, web3j, credentials, GAS_PRICE, GAS_LIMIT);
        evoting.initializeVote(vote.get_name(), BigInteger.valueOf(vote.get_endDate()), BigInteger.valueOf(vote.get_codesCount())).send();
        String name = evoting.getName().send();
        return ResponseEntity.ok(name);
    }
    mmj.evoting.contract.Vote vote;
    @PostMapping(path = "/vote/prepareVoter", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity prepareVoter() throws Exception {
        String voteAddress = mmj.evoting.contract.Vote.deploy(web3j,credentials,GAS_PRICE,GAS_LIMIT).send().getContractAddress();
        vote = mmj.evoting.contract.Vote.load(voteAddress,web3j,credentials,GAS_PRICE,GAS_LIMIT);
        String codesAddress = Codes.deploy(web3j,credentials,GAS_PRICE,GAS_LIMIT).send().getContractAddress();
        Codes codes = Codes.load(codesAddress,web3j,credentials,GAS_PRICE,GAS_LIMIT);
        codes.prepareCodes(BigInteger.valueOf(2)).send();
        System.out.println(codes.getCodes().send());
        vote.prepareVoter("Maciej","Bigos",codes.getCodes().send());
        return ResponseEntity.ok(vote.getCodesCount().send());
    }

    @PostMapping(path = "vote/vote/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity vote(@PathVariable long id) throws Exception {
        vote.vote(BigInteger.valueOf(id)).send();
        return ResponseEntity.ok(vote.getCodesCount().send());
    }

    @PostMapping(path = "vote/finalize")
    public ResponseEntity fin() throws Exception {
        vote.finalizeVote(contractAddress).send();
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/vote/getCandidateByID/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity getCandidateByID(@PathVariable long id) {
        Evoting.Candidate candidate = null;
        try {
            candidate = evoting.getCandidateByID(BigInteger.valueOf(id)).send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (candidate == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(candidate);
    }

    @PutMapping(path = "/vote/addVoteToCandidate/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity addVoteToCandidate(@PathVariable long id) {
        try {
            evoting.addVoteToCandidate(BigInteger.valueOf(id)).send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/vote/addCandidate", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity addCandidate(@RequestBody String name) throws Exception {
        evoting.addCandidate(name).send();
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/vote/getNbOfCandidates", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity getNumberOfcandidates() throws Exception {
        BigInteger nb = evoting.getNumberOfcandidates().send();
        return ResponseEntity.ok(nb);
    }

    @GetMapping(path = "/vote/getResult", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity getResult() {
        Evoting.Candidate candidate = null;
        try {
            candidate = evoting.getReslut().send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (candidate == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(candidate);
    }

}