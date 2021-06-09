package mmj.evoting.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class Vote extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061083b806100206000396000f3fe608060405234801561001057600080fd5b50600436106100935760003560e01c806370218b851161006657806370218b8514610103578063859884991461010b578063932997f11461011e578063c29fb0f114610126578063fcb821171461013b57600080fd5b80630121b93f146100985780631cca745b146100ad57806338cc4831146100d35780636b109282146100ee575b600080fd5b6100ab6100a63660046106ac565b610143565b005b6100c06100bb3660046105a5565b610191565b6040519081526020015b60405180910390f35b6002546040516001600160a01b0390911681526020016100ca565b6100f66101eb565b6040516100ca9190610770565b6004546100c0565b6100ab610119366004610577565b61027d565b6100f66102db565b61012e6102ea565b6040516100ca919061070f565b6003546100c0565b6003541561018e576004819055600380548061016f57634e487b7160e01b600052603160045260246000fd5b60019003818190600052602060002001600061018b91906103c3565b90555b50565b82516000906101a690829060208701906103fd565b5082516101ba9060019060208601906103fd565b50600280546001600160a01b0319163317905581516101e0906003906020850190610481565b506000949350505050565b6060600180546101fa906107b4565b80601f0160208091040260200160405190810160405280929190818152602001828054610226906107b4565b80156102735780601f1061024857610100808354040283529160200191610273565b820191906000526020600020905b81548152906001019060200180831161025657829003601f168201915b5050505050905090565b6004805460405163fe37d61560e01b8152918201526001600160a01b0382169063fe37d61590602401600060405180830381600087803b1580156102c057600080fd5b505af11580156102d4573d6000803e3d6000fd5b5050505050565b6060600080546101fa906107b4565b60606003805480602002602001604051908101604052809291908181526020016000905b828210156103ba57838290600052602060002001805461032d906107b4565b80601f0160208091040260200160405190810160405280929190818152602001828054610359906107b4565b80156103a65780601f1061037b576101008083540402835291602001916103a6565b820191906000526020600020905b81548152906001019060200180831161038957829003601f168201915b50505050508152602001906001019061030e565b50505050905090565b5080546103cf906107b4565b6000825580601f106103df575050565b601f01602090049060005260206000209081019061018e91906104da565b828054610409906107b4565b90600052602060002090601f01602090048101928261042b5760008555610471565b82601f1061044457805160ff1916838001178555610471565b82800160010185558215610471579182015b82811115610471578251825591602001919060010190610456565b5061047d9291506104da565b5090565b8280548282559060005260206000209081019282156104ce579160200282015b828111156104ce57825180516104be9184916020909101906103fd565b50916020019190600101906104a1565b5061047d9291506104ef565b5b8082111561047d57600081556001016104db565b8082111561047d57600061050382826103c3565b506001016104ef565b600082601f83011261051c578081fd5b813567ffffffffffffffff811115610536576105366107ef565b610549601f8201601f1916602001610783565b81815284602083860101111561055d578283fd5b816020850160208301379081016020019190915292915050565b600060208284031215610588578081fd5b81356001600160a01b038116811461059e578182fd5b9392505050565b6000806000606084860312156105b9578182fd5b833567ffffffffffffffff808211156105d0578384fd5b6105dc8783880161050c565b94506020915081860135818111156105f2578485fd5b6105fe8882890161050c565b945050604086013581811115610612578384fd5b8601601f81018813610622578384fd5b803582811115610634576106346107ef565b8060051b610643858201610783565b8281528581019084870183860188018d101561065d578889fd5b8893505b8484101561069a5780358781111561067757898afd5b6106858e8a838a010161050c565b84525060019390930192918701918701610661565b50809750505050505050509250925092565b6000602082840312156106bd578081fd5b5035919050565b60008151808452815b818110156106e9576020818501810151868301820152016106cd565b818111156106fa5782602083870101525b50601f01601f19169290920160200192915050565b6000602080830181845280855180835260408601915060408160051b8701019250838701855b8281101561076357603f198886030184526107518583516106c4565b94509285019290850190600101610735565b5092979650505050505050565b60208152600061059e60208301846106c4565b604051601f8201601f1916810167ffffffffffffffff811182821017156107ac576107ac6107ef565b604052919050565b600181811c908216806107c857607f821691505b602082108114156107e957634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052604160045260246000fdfea264697066735822122051598e42e7de461cb917335c2df2c68532241d13ce5ebf9ed82ab3ca681afbed64736f6c63430008040033";

    public static final String FUNC_FINALIZEVOTE = "finalizeVote";

    public static final String FUNC_GETADDRESS = "getAddress";

    public static final String FUNC_GETCANDIDATE = "getCandidate";

    public static final String FUNC_GETCODES = "getCodes";

    public static final String FUNC_GETCODESCOUNT = "getCodesCount";

    public static final String FUNC_GETFIRSTNAME = "getFirstName";

    public static final String FUNC_GETLASTNAME = "getLastName";

    public static final String FUNC_PREPAREVOTER = "prepareVoter";

    public static final String FUNC_VOTE = "vote";

    @Deprecated
    protected Vote(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Vote(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Vote(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Vote(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> finalizeVote(String evoting) {
        final Function function = new Function(
                FUNC_FINALIZEVOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, evoting)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getAddress() {
        final Function function = new Function(FUNC_GETADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getCandidate() {
        final Function function = new Function(FUNC_GETCANDIDATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<List> getCodes() {
        final Function function = new Function(FUNC_GETCODES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Utf8String>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> getCodesCount() {
        final Function function = new Function(
                FUNC_GETCODESCOUNT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getFirstName() {
        final Function function = new Function(FUNC_GETFIRSTNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getLastName() {
        final Function function = new Function(FUNC_GETLASTNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> prepareVoter(String firstname, String lastName, List<String> codes) {
        final Function function = new Function(
                FUNC_PREPAREVOTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(firstname), 
                new org.web3j.abi.datatypes.Utf8String(lastName), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Utf8String>(
                        org.web3j.abi.datatypes.Utf8String.class,
                        org.web3j.abi.Utils.typeMap(codes, org.web3j.abi.datatypes.Utf8String.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> vote(BigInteger candidateNum) {
        final Function function = new Function(
                FUNC_VOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(candidateNum)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Vote load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Vote(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Vote load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Vote(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Vote load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Vote(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Vote load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Vote(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Vote> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Vote.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Vote> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Vote.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Vote> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Vote.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Vote> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Vote.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
