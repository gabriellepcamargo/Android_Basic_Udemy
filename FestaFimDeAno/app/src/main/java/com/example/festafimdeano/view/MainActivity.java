package com.example.festafimdeano.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.festafimdeano.R;
import com.example.festafimdeano.constant.FimDeAnoConstant;
import com.example.festafimdeano.data.SecurityPreferences;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //1° faço a instancia da viewHolder
    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;
    private static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instanciei a variavel dentro do oncreate e agora já posso usar o Security preference
        this.mSecurityPreferences = new SecurityPreferences(this);
        //3° Encontro elementos de interface
        this.mViewHolder.textToday = findViewById(R.id.textToday);
        this.mViewHolder.textDaysLeft = findViewById(R.id.text_day_left);
        this.mViewHolder.buttonConfirm = findViewById(R.id.button_confirm);

        this.mViewHolder.buttonConfirm.setOnClickListener(this);

        //Datas
        this.mViewHolder.textToday.setText(SIMPLE_DATE_FORMAT.format(Calendar.getInstance().getTime()));
        String daysLeft = String.format("%s %s", String.valueOf(this.getDaysLef()), getString(R.string.dias));
        this.mViewHolder.textDaysLeft.setText(daysLeft);

    }

    @Override
    protected void onResume() {
        super.onResume();
        this.verifyPresence();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_confirm) {
            String presence = this.mSecurityPreferences.getStoreString(FimDeAnoConstant.PRESENCE_KEY);
            Intent intent = new Intent(this, DetailsActivity.class);//funciona com this pq a class main extends a APPCompatActivityo segundo parametro é quem vc quer abrir
            intent.putExtra(FimDeAnoConstant.PRESENCE_KEY,presence);
            startActivity(intent);//executo a intenção
        }

    }

    private void verifyPresence() {
        //não confirmado
        //já confirmou e vai
        //já confirmou e não vai
        String presence = this.mSecurityPreferences.getStoreString(FimDeAnoConstant.PRESENCE_KEY);

        if (presence.equals("")) {
            this.mViewHolder.buttonConfirm.setText(getString(R.string.nao_corfirmado));
        } else if (presence.equals(FimDeAnoConstant.CONFIRMATION_YES)) {
            this.mViewHolder.buttonConfirm.setText(getString(R.string.sim));
        } else {
            this.mViewHolder.buttonConfirm.setText(getString(R.string.nao));
        }
    }

    private int getDaysLef() {
        //data de hoje
        Calendar calendarToday = Calendar.getInstance();
        int today = calendarToday.get(Calendar.DAY_OF_YEAR);
        // dia max do ano 1-365
        Calendar calendarLastDay = Calendar.getInstance();
        int dayMax = calendarLastDay.getActualMaximum(Calendar.DAY_OF_YEAR);

        return dayMax - today;
    }

    private static class ViewHolder {
        //2° Mapear elementos de interface
        TextView textToday;
        TextView textDaysLeft;
        Button buttonConfirm;

    }
}
