package com.minorius.travel;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.minorius.travel.mvp.fragmentpresenter.FragmentModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by minorius on 09.08.2017.
 */

public class DetailsActivity extends AppCompatActivity {

    LoadedDetails loadedDetails;

    @BindView(R.id.id_web_details_info) WebView webView;
    @BindView(R.id.id_progress_bar) ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        String text = FragmentModel.URL_PATH_BUS+bundle.getString("ID");

        loadedDetails = new LoadedDetails();
        loadedDetails.execute(text);

    }

    private class LoadedDetails extends AsyncTask<String, Void, String>{

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(String... params) {
            for (String uri : params){

                try {
                    Document doc = Jsoup.connect(uri).get();
                    Elements data = doc.select("tbody").select("table");
                    return  data.get(1).outerHtml();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return  null;
        }

        @Override
        protected void onPostExecute(String s) {
            progressBar.setVisibility(View.GONE);
            super.onPostExecute(s);
            webView.loadData(s, "text/html; charset=utf-8", "UTF-8");
        }
    }

    @Override
    public void onBackPressed() {

        if (loadedDetails!=null){
            loadedDetails.cancel(true);
        }
        super.onBackPressed();
    }
}
