package mmj.evoting.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicStruct;
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
public class Evoting extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610c1e806100206000396000f3fe608060405234801561001057600080fd5b50600436106100cf5760003560e01c8063831983e61161008c578063d28d885211610066578063d28d88521461019b578063dbfa5863146101a3578063fa1f9fc2146101ac578063fe37d615146101b457600080fd5b8063831983e61461015b578063893d20e814610163578063b2bdfa7b1461018857600080fd5b80631686a4b9146100d457806317d7de7c146100eb57806336f56b1214610100578063462e91ec1461011557806353e61a6114610128578063822023961461013b575b600080fd5b6004545b6040519081526020015b60405180910390f35b6100f36101c9565b6040516100e29190610b27565b61010861025b565b6040516100e29190610ac6565b6100d86101233660046109a9565b610360565b6100d86101363660046109e4565b6103e1565b61014e610149366004610a30565b61041c565b6040516100e29190610b41565b6003546100d8565b6000546001600160a01b03165b6040516001600160a01b0390911681526020016100e2565b600054610170906001600160a01b031681565b6100f3610587565b6100d860025481565b61014e610615565b6101c76101c2366004610a30565b6107b6565b005b6060600180546101d890610b6c565b80601f016020809104026020016040519081016040528092919081815260200182805461020490610b6c565b80156102515780601f1061022657610100808354040283529160200191610251565b820191906000526020600020905b81548152906001019060200180831161023457829003601f168201915b5050505050905090565b60606004805480602002602001604051908101604052809291908181526020016000905b828210156103575783829060005260206000209060030201604051806060016040529081600082015481526020016001820180546102bc90610b6c565b80601f01602080910402602001604051908101604052809291908181526020018280546102e890610b6c565b80156103355780601f1061030a57610100808354040283529160200191610335565b820191906000526020600020905b81548152906001019060200180831161031857829003601f168201915b505050505081526020016002820154815250508152602001906001019061027f565b50505050905090565b60048054604080516060810190915260009290808361037e81610ba1565b908252602080830188905260006040909301839052845460018181018755958452928190208451600390940201928355838101518051929650939492936103ca93850192910190610889565b506040820151816002015550506000915050919050565b82516000906103f7906001906020870190610889565b50506002829055600080546001600160a01b0319163317815560038290559392505050565b61044060405180606001604052806000815260200160608152602001600081525090565b60005b60045481101561058157826004828154811061046f57634e487b7160e01b600052603260045260246000fd5b906000526020600020906003020160000154141561056f57600481815481106104a857634e487b7160e01b600052603260045260246000fd5b9060005260206000209060030201604051806060016040529081600082015481526020016001820180546104db90610b6c565b80601f016020809104026020016040519081016040528092919081815260200182805461050790610b6c565b80156105545780601f1061052957610100808354040283529160200191610554565b820191906000526020600020905b81548152906001019060200180831161053757829003601f168201915b50505050508152602001600282015481525050915050919050565b8061057981610ba1565b915050610443565b50919050565b6001805461059490610b6c565b80601f01602080910402602001604051908101604052809291908181526020018280546105c090610b6c565b801561060d5780601f106105e25761010080835404028352916020019161060d565b820191906000526020600020905b8154815290600101906020018083116105f057829003601f168201915b505050505081565b61063960405180606001604052806000815260200160608152602001600081525090565b60008060005b6004548110156106ce57826004828154811061066b57634e487b7160e01b600052603260045260246000fd5b90600052602060002090600302016002015411156106bc57600481815481106106a457634e487b7160e01b600052603260045260246000fd5b90600052602060002090600302016002015492508091505b806106c681610ba1565b91505061063f565b50600481815481106106f057634e487b7160e01b600052603260045260246000fd5b90600052602060002090600302016040518060600160405290816000820154815260200160018201805461072390610b6c565b80601f016020809104026020016040519081016040528092919081815260200182805461074f90610b6c565b801561079c5780601f106107715761010080835404028352916020019161079c565b820191906000526020600020905b81548152906001019060200180831161077f57829003601f168201915b505050505081526020016002820154815250509250505090565b60005b6004548110156108855781600482815481106107e557634e487b7160e01b600052603260045260246000fd5b9060005260206000209060030201600001541415610873576004818154811061081e57634e487b7160e01b600052603260045260246000fd5b906000526020600020906003020160020154600161083c9190610b54565b6004828154811061085d57634e487b7160e01b600052603260045260246000fd5b9060005260206000209060030201600201819055505b8061087d81610ba1565b9150506107b9565b5050565b82805461089590610b6c565b90600052602060002090601f0160209004810192826108b757600085556108fd565b82601f106108d057805160ff19168380011785556108fd565b828001600101855582156108fd579182015b828111156108fd5782518255916020019190600101906108e2565b5061090992915061090d565b5090565b5b80821115610909576000815560010161090e565b600082601f830112610932578081fd5b813567ffffffffffffffff8082111561094d5761094d610bd2565b604051601f8301601f19908116603f0116810190828211818310171561097557610975610bd2565b8160405283815286602085880101111561098d578485fd5b8360208701602083013792830160200193909352509392505050565b6000602082840312156109ba578081fd5b813567ffffffffffffffff8111156109d0578182fd5b6109dc84828501610922565b949350505050565b6000806000606084860312156109f8578182fd5b833567ffffffffffffffff811115610a0e578283fd5b610a1a86828701610922565b9660208601359650604090950135949350505050565b600060208284031215610a41578081fd5b5035919050565b60008151808452815b81811015610a6d57602081850181015186830182015201610a51565b81811115610a7e5782602083870101525b50601f01601f19169290920160200192915050565b805182526000602082015160606020850152610ab26060850182610a48565b604093840151949093019390935250919050565b6000602080830181845280855180835260408601915060408160051b8701019250838701855b82811015610b1a57603f19888603018452610b08858351610a93565b94509285019290850190600101610aec565b5092979650505050505050565b602081526000610b3a6020830184610a48565b9392505050565b602081526000610b3a6020830184610a93565b60008219821115610b6757610b67610bbc565b500190565b600181811c90821680610b8057607f821691505b6020821081141561058157634e487b7160e01b600052602260045260246000fd5b6000600019821415610bb557610bb5610bbc565b5060010190565b634e487b7160e01b600052601160045260246000fd5b634e487b7160e01b600052604160045260246000fdfea26469706673582212200d0cb24a12cbbdd118e6e266d89a220d84d8bdda743aa928779f4c6e57d41c0664736f6c63430008040033";

    public static final String FUNC__ENDDATE = "_endDate";

    public static final String FUNC__NAME = "_name";

    public static final String FUNC__OWNER = "_owner";

    public static final String FUNC_ADDCANDIDATE = "addCandidate";

    public static final String FUNC_ADDVOTETOCANDIDATE = "addVoteToCandidate";

    public static final String FUNC_GETCANDIDATEBYID = "getCandidateByID";

    public static final String FUNC_GETCODECOUNT = "getCodeCount";

    public static final String FUNC_GETNAME = "getName";

    public static final String FUNC_GETNUMBEROFCANDIDATES = "getNumberOfcandidates";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_GETRESLUT = "getReslut";

    public static final String FUNC_GETCANDIDATES = "getcandidates";

    public static final String FUNC_INITIALIZEVOTE = "initializeVote";

    @Deprecated
    protected Evoting(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Evoting(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Evoting(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Evoting(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> _endDate() {
        final Function function = new Function(FUNC__ENDDATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> _name() {
        final Function function = new Function(FUNC__NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> _owner() {
        final Function function = new Function(FUNC__OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> addCandidate(String name2) {
        final Function function = new Function(
                FUNC_ADDCANDIDATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name2)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addVoteToCandidate(BigInteger ID) {
        final Function function = new Function(
                FUNC_ADDVOTETOCANDIDATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(ID)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Candidate> getCandidateByID(BigInteger ID) {
        final Function function = new Function(FUNC_GETCANDIDATEBYID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(ID)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Candidate>() {}));
        return executeRemoteCallSingleValueReturn(function, Candidate.class);
    }

    public RemoteFunctionCall<BigInteger> getCodeCount() {
        final Function function = new Function(FUNC_GETCODECOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getName() {
        final Function function = new Function(FUNC_GETNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getNumberOfcandidates() {
        final Function function = new Function(FUNC_GETNUMBEROFCANDIDATES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getOwner() {
        final Function function = new Function(FUNC_GETOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Candidate> getReslut() {
        final Function function = new Function(FUNC_GETRESLUT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Candidate>() {}));
        return executeRemoteCallSingleValueReturn(function, Candidate.class);
    }

    public RemoteFunctionCall<List> getcandidates() {
        final Function function = new Function(FUNC_GETCANDIDATES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Candidate>>() {}));
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

    public RemoteFunctionCall<TransactionReceipt> initializeVote(String name, BigInteger endDate, BigInteger codesCount) {
        final Function function = new Function(
                FUNC_INITIALIZEVOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.generated.Uint256(endDate), 
                new org.web3j.abi.datatypes.generated.Uint256(codesCount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Evoting load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Evoting(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Evoting load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Evoting(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Evoting load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Evoting(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Evoting load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Evoting(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Evoting> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Evoting.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Evoting> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Evoting.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Evoting> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Evoting.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Evoting> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Evoting.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class Candidate extends DynamicStruct {
        public BigInteger _ID;

        public String _name;

        public BigInteger _voteCount;

        public Candidate(BigInteger _ID, String _name, BigInteger _voteCount) {
            super(new org.web3j.abi.datatypes.generated.Uint256(_ID),new org.web3j.abi.datatypes.Utf8String(_name),new org.web3j.abi.datatypes.generated.Uint256(_voteCount));
            this._ID = _ID;
            this._name = _name;
            this._voteCount = _voteCount;
        }

        public Candidate(Uint256 _ID, Utf8String _name, Uint256 _voteCount) {
            super(_ID,_name,_voteCount);
            this._ID = _ID.getValue();
            this._name = _name.getValue();
            this._voteCount = _voteCount.getValue();
        }
    }
}
