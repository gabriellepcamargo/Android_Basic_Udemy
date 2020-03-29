package com.example.festafimdeano.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.festafimdeano.R;
import com.example.festafimdeano.constant.FimDeAnoConstant;
import com.example.festafimdeano.data.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener{
    //crio variavel p poder acessar
    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) { // resposavel por criar o contexto
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        this.mSecurityPreferences = new SecurityPreferences(this);
        this.mViewHolder.checkParticipate = findViewById(R.id.check_participate);
        this.mViewHolder.checkParticipate.setOnClickListener(this);

        this.loadDataFromActivity();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.check_participate){
            if(this.mViewHolder.checkParticipate.isChecked()){
                //Salvo presença
                this.mSecurityPreferences.storeString(FimDeAnoConstant.PRESENCE_KEY, FimDeAnoConstant.CONFIRMATION_YES);
            }else{
                //salvo ausencia
                this.mSecurityPreferences.storeString(FimDeAnoConstant.PRESENCE_KEY, FimDeAnoConstant.CONFIRMATION_NO);

            }
        }
    }
    private void loadDataFromActivity(){
        Bundle extra = getIntent().getExtras();
        if(extra != null){
            String presence = extra.getString(FimDeAnoConstant.PRESENCE_KEY);
            if(presence != null && presence.equals(FimDeAnoConstant.CONFIRMATION_YES)){
                this.mViewHolder.checkParticipate.setChecked(true);
            }else {
                this.mViewHolder.checkParticipate.setChecked(false);
            }

        }
    }

    private static class ViewHolder{
        CheckBox checkParticipate;
    }
}
