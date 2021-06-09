package mmj.evoting.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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
public class Codes extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610731806100206000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c80630b352c5c1461003b578063c29fb0f114610064575b600080fd5b61004e610049366004610572565b61006c565b60405161005b919061058a565b60405180910390f35b61004e6101cc565b606060005b828110156100f25760006100ba6040518060400160405280601d81526020017f4f6e636555706f6e4154696d6545566f74696e67446174614c65616b73000000815250836102a5565b8154600181018355600092835260209283902082516100df94919092019201906104d9565b50806100ea816106a0565b915050610071565b506000805480602002602001604051908101604052809291908181526020016000905b828210156101c157838290600052602060002001805461013490610665565b80601f016020809104026020016040519081016040528092919081815260200182805461016090610665565b80156101ad5780601f10610182576101008083540402835291602001916101ad565b820191906000526020600020905b81548152906001019060200180831161019057829003601f168201915b505050505081526020019060010190610115565b505050509050919050565b60606000805480602002602001604051908101604052809291908181526020016000905b8282101561029c57838290600052602060002001805461020f90610665565b80601f016020809104026020016040519081016040528092919081815260200182805461023b90610665565b80156102885780601f1061025d57610100808354040283529160200191610288565b820191906000526020600020905b81548152906001019060200180831161026b57829003601f168201915b5050505050815260200190600101906101f0565b50505050905090565b60408051606480825260a08201909252606091906000908260208201818036833701905050905060005b84156103475760006102e2600a876106bb565b90506102ef600a8761063a565b95506102fc816030610622565b60f81b838361030a816106a0565b94508151811061032a57634e487b7160e01b600052603260045260246000fd5b60200101906001600160f81b031916908160001a905350506102cf565b85518690600090610359908490610622565b67ffffffffffffffff81111561037f57634e487b7160e01b600052604160045260246000fd5b6040519080825280601f01601f1916602001820160405280156103a9576020820181803683370190505b50905060005b825181101561042c578281815181106103d857634e487b7160e01b600052603260045260246000fd5b602001015160f81c60f81b82828151811061040357634e487b7160e01b600052603260045260246000fd5b60200101906001600160f81b031916908160001a90535080610424816106a0565b9150506103af565b5060005b838110156104cd57848161044560018761064e565b61044f919061064e565b8151811061046d57634e487b7160e01b600052603260045260246000fd5b602001015160f81c60f81b828451836104869190610622565b815181106104a457634e487b7160e01b600052603260045260246000fd5b60200101906001600160f81b031916908160001a905350806104c5816106a0565b915050610430565b50979650505050505050565b8280546104e590610665565b90600052602060002090601f016020900481019282610507576000855561054d565b82601f1061052057805160ff191683800117855561054d565b8280016001018555821561054d579182015b8281111561054d578251825591602001919060010190610532565b5061055992915061055d565b5090565b5b80821115610559576000815560010161055e565b600060208284031215610583578081fd5b5035919050565b6000602080830181845280855180835260408601915060408160051b8701019250838701855b8281101561061557878503603f1901845281518051808752885b818110156105e5578281018901518882018a015288016105ca565b818111156105f5578989838a0101525b50601f01601f1916959095018601945092850192908501906001016105b0565b5092979650505050505050565b60008219821115610635576106356106cf565b500190565b600082610649576106496106e5565b500490565b600082821015610660576106606106cf565b500390565b600181811c9082168061067957607f821691505b6020821081141561069a57634e487b7160e01b600052602260045260246000fd5b50919050565b60006000198214156106b4576106b46106cf565b5060010190565b6000826106ca576106ca6106e5565b500690565b634e487b7160e01b600052601160045260246000fd5b634e487b7160e01b600052601260045260246000fdfea2646970667358221220318443a3c482ce19d6f962c1d3fc1f38ff2a52f12198175eb5518b4dcea3740c64736f6c63430008040033";

    public static final String FUNC_GETCODES = "getCodes";

    public static final String FUNC_PREPARECODES = "prepareCodes";

    @Deprecated
    protected Codes(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Codes(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Codes(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Codes(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
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

    public RemoteFunctionCall<TransactionReceipt> prepareCodes(BigInteger count) {
        final Function function = new Function(
                FUNC_PREPARECODES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(count)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Codes load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Codes(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Codes load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Codes(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Codes load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Codes(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Codes load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Codes(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Codes> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Codes.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Codes> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Codes.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Codes> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Codes.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Codes> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Codes.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
