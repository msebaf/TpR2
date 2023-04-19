package usuario.example.tpanexoa;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class LogginActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Boolean> resultado=null;
    private MutableLiveData<Boolean> resultaoNegativo = null;

    String uName = "msf";
    String pass = "msf";

    public LogginActivityViewModel(@NonNull Application application) {
        super(application);

    }

    public LiveData<Boolean> getResultado(){
        if(resultado==null){

            this.resultado=new MutableLiveData<>();

        }
        return resultado;
    }
    public LiveData<Boolean> getResultadoNegativo(){
        if(resultaoNegativo==null){

            this.resultaoNegativo=new MutableLiveData<>();

        }
        return resultaoNegativo;
    }
    public void validar(String userName, String password){
        Log.d("resulatdo", ((userName.equals(uName) && password.equals(pass))+""));
        Log.d("aa", uName);
        Log.d("aa", pass);
        Log.d("bb", userName);
        Log.d("bb", password);

        if((userName.equals(uName) && password.equals(pass))){
            resultado.setValue(true);
        }else{
            resultaoNegativo.setValue(true);
        }

    }
}