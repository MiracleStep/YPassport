package com.mirac.main.ypassport.service;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class Recipel extends Contract {

    private static final String BINARY = "60806040526000805534801561001457600080fd5b5033600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550610e36806100656000396000f3006080604052600436106100db576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806302eb602d146100e057806304a7ff18146101475780632860f962146101725780632fe1f8b7146101d957806355e286551461021a578063571c3e601461025f5780637f4989df146102af578063a9583c221461030a578063ab82d9a014610365578063ac71a5c6146103aa578063ccc88dfd14610417578063ded96eb71461045c578063e2a6f547146104a1578063ede270a4146104ec578063f15f58bb1461059c575b600080fd5b3480156100ec57600080fd5b5061012d6004803603810190808035906020019092919080359060200190929190803590602001908201803590602001919091929391929390505050610609565b604051808215151515815260200191505060405180910390f35b34801561015357600080fd5b5061015c610737565b6040518082815260200191505060405180910390f35b34801561017e57600080fd5b506101bf600480360381019080803590602001909291908035906020019092919080359060200190820180359060200191909192939192939050505061073d565b604051808215151515815260200191505060405180910390f35b3480156101e557600080fd5b506102046004803603810190808035906020019092919050505061089c565b6040518082815260200191505060405180910390f35b34801561022657600080fd5b50610245600480360381019080803590602001909291905050506108b4565b604051808215151515815260200191505060405180910390f35b34801561026b57600080fd5b506102ad600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803560ff1690602001909291905050506108d4565b005b3480156102bb57600080fd5b506102f0600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610a03565b604051808215151515815260200191505060405180910390f35b34801561031657600080fd5b5061034b600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610a23565b604051808215151515815260200191505060405180910390f35b34801561037157600080fd5b5061039060048036038101908080359060200190929190505050610a43565b604051808215151515815260200191505060405180910390f35b3480156103b657600080fd5b506103d560048036038101908080359060200190929190505050610a63565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561042357600080fd5b5061044260048036038101908080359060200190929190505050610a96565b604051808215151515815260200191505060405180910390f35b34801561046857600080fd5b5061048760048036038101908080359060200190929190505050610b73565b604051808215151515815260200191505060405180910390f35b3480156104ad57600080fd5b506104d66004803603810190808035906020019092919080359060200190929190505050610c50565b6040518082815260200191505060405180910390f35b3480156104f857600080fd5b506105216004803603810190808035906020019092919080359060200190929190505050610c75565b6040518080602001828103825283818151815260200191508051906020019080838360005b83811015610561578082015181840152602081019050610546565b50505050905090810190601f16801561058e5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156105a857600080fd5b506105c760048036038101908080359060200190929190505050610d32565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6000600960003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16151561066357600080fd5b82826002600088815260200190815260200160002060008081526020019081526020016000209190610696929190610d65565b50836003600087815260200190815260200160002060008081526020019081526020016000208190555060006004600087815260200190815260200160002081905550336005600087815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060019050949350505050565b60005481565b600080853373ffffffffffffffffffffffffffffffffffffffff166005600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415156107ae57600080fd5b600160046000898152602001908152602001600020540191508484600260008a8152602001908152602001600020600085815260200190815260200160002091906107fa929190610d65565b508560036000898152602001908152602001600020600084815260200190815260200160002081905550816004600089815260200190815260200160002081905550336005600089815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600192505050949350505050565b60046020528060005260406000206000915090505481565b60076020528060005260406000206000915054906101000a900460ff1681565b3373ffffffffffffffffffffffffffffffffffffffff16600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614151561093057600080fd5b60018160ff161415610999576001600960008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055506109ff565b60028160ff1614156109fe576001600a60008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055505b5b5050565b600a6020528060005260406000206000915054906101000a900460ff1681565b60096020528060005260406000206000915054906101000a900460ff1681565b60086020528060005260406000206000915054906101000a900460ff1681565b60056020528060005260406000206000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000600a60003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff161515610af057600080fd5b60016007600084815260200190815260200160002060006101000a81548160ff021916908315150217905550336006600084815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550919050565b6000600a60003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff161515610bcd57600080fd5b60016008600084815260200190815260200160002060006101000a81548160ff021916908315150217905550336006600084815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550919050565b6003602052816000526040600020602052806000526040600020600091509150505481565b6002602052816000526040600020602052806000526040600020600091509150508054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610d2a5780601f10610cff57610100808354040283529160200191610d2a565b820191906000526020600020905b815481529060010190602001808311610d0d57829003601f168201915b505050505081565b60066020528060005260406000206000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610da657803560ff1916838001178555610dd4565b82800160010185558215610dd4579182015b82811115610dd3578235825591602001919060010190610db8565b5b509050610de19190610de5565b5090565b610e0791905b80821115610e03576000816000905550600101610deb565b5090565b905600a165627a7a72305820daa954c96bb1332269ccb16fa99260e1ce7c8392760bf040e1e1167d9d7a43bf0029";

    public static final String FUNC_CREATERX = "createRx";

    public static final String FUNC_TOTALNUM = "totalNum";

    public static final String FUNC_UPDATERX = "updateRx";

    public static final String FUNC_CURVERSIONS = "curVersions";

    public static final String FUNC_CONFIRMS = "confirms";

    public static final String FUNC_SETROLE = "setRole";

    public static final String FUNC_HERBALISTS = "herbalists";

    public static final String FUNC_DOCTORS = "doctors";

    public static final String FUNC_CHALLENGE = "challenge";

    public static final String FUNC_CURDOCTORS = "curDoctors";

    public static final String FUNC_CONFIRMRX = "confirmRx";

    public static final String FUNC_CHALLENGERX = "challengeRx";

    public static final String FUNC_PRICES = "prices";

    public static final String FUNC_RECIPELS = "recipels";

    public static final String FUNC_CURHERBALISTS = "curHerbalists";

    public Recipel(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Recipel(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> createRx(BigInteger rxId, BigInteger price, String recipel) {
        final Function function = new Function(
                FUNC_CREATERX, 
                Arrays.<Type>asList(new Uint256(rxId),
                new Uint256(price),
                new Utf8String(recipel)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> totalNum() {
        final Function function = new Function(FUNC_TOTALNUM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> updateRx(BigInteger rxId, BigInteger price, String recipel) {
        final Function function = new Function(
                FUNC_UPDATERX, 
                Arrays.<Type>asList(new Uint256(rxId),
                new Uint256(price),
                new Utf8String(recipel)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> curVersions(BigInteger param0) {
        final Function function = new Function(FUNC_CURVERSIONS, 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> confirms(BigInteger param0) {
        final Function function = new Function(FUNC_CONFIRMS, 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> setRole(String user, BigInteger roleType) {
        final Function function = new Function(
                FUNC_SETROLE, 
                Arrays.<Type>asList(new Address(user),
                new org.web3j.abi.datatypes.generated.Uint8(roleType)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> herbalists(String param0) {
        final Function function = new Function(FUNC_HERBALISTS, 
                Arrays.<Type>asList(new Address(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Boolean> doctors(String param0) {
        final Function function = new Function(FUNC_DOCTORS, 
                Arrays.<Type>asList(new Address(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Boolean> challenge(BigInteger param0) {
        final Function function = new Function(FUNC_CHALLENGE, 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> curDoctors(BigInteger param0) {
        final Function function = new Function(FUNC_CURDOCTORS, 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> confirmRx(BigInteger rxId) {
        final Function function = new Function(
                FUNC_CONFIRMRX, 
                Arrays.<Type>asList(new Uint256(rxId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> challengeRx(BigInteger rxId) {
        final Function function = new Function(
                FUNC_CHALLENGERX, 
                Arrays.<Type>asList(new Uint256(rxId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> prices(BigInteger param0, BigInteger param1) {
        final Function function = new Function(FUNC_PRICES, 
                Arrays.<Type>asList(new Uint256(param0),
                new Uint256(param1)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> recipels(BigInteger param0, BigInteger param1) {
        final Function function = new Function(FUNC_RECIPELS, 
                Arrays.<Type>asList(new Uint256(param0),
                new Uint256(param1)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> curHerbalists(BigInteger param0) {
        final Function function = new Function(FUNC_CURHERBALISTS, 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static RemoteCall<Recipel> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Recipel.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Recipel> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Recipel.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Recipel load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Recipel(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Recipel load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Recipel(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
