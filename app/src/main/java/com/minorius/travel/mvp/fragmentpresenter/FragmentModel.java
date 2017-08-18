package com.minorius.travel.mvp.fragmentpresenter;

import android.os.AsyncTask;
import android.util.Log;

import com.minorius.travel.pojo.Bus;
import com.minorius.travel.pojo.ExtraBus;
import com.minorius.travel.pojo.Train;
import com.minorius.travel.pojo.UpdateTrain;
import com.minorius.travel.realm.TrainCherkasySmilaRealm;
import com.minorius.travel.realm.TrainSmilaCherkasyRealm;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by minorius on 17.08.2017.
 */

public class FragmentModel {

    public static final String URL_PATH_BUS = "http://bus.com.ua/cgi-bin/bus-order?";

    public static final String URL_PATH_TRAIN_CHERKASY_SMILA = "http://poezdato.net/raspisanie-poezdov/cherkassy--im-tarasa-shevchenko/";
    public static final String URL_PATH_TRAIN_SMILA_CHERKASY = "http://poezdato.net/raspisanie-poezdov/smela--cherkassy/";

    public ArrayList<Object> getListBus(int id) {
        switch (id) {
            case 1:
                return getListBusCherkasySmila();
            case 2:
                return getListBusSmilaCherkasy();
            case 3:
                return getListBusCherkasySokirno();
            case 4:
                return getListBusSokirnoCherkasy();
        }
        return null;
    }

    public ArrayList<Object> getListTrain(int id) {
        switch (id) {
            case 1:
                return loadDataFromDbCherkasySmila();
            case 2:
                return loadDataFromDbSmilaCherkasy();
        }
        return null;
    }

    private ArrayList<Object> getListBusCherkasySokirno() {
        ArrayList<Object> list = new ArrayList<>();

        list.add(new Bus("з ринку", "Черкаси - Сокирне", "07:05 - 08:00", "b=712100&r=477%CF"));
        list.add(new Bus("з ринку", "Черкаси - Сокирне", "08:05 - 08:55", "b=712100&r=251%CF"));
        list.add(new ExtraBus("з вокзалу", "Черкаси - Будище", "08:40 - 09:45", "b=712000&r=83%CF"));
        list.add(new Bus("з ринку", "Черкаси - Сокирне", "10:10 - 10:55", "b=712100&r=253%CF"));
        list.add(new Bus("з ринку", "Черкаси - Сокирне", "12:20 - 13:05", "b=712100&r=255%CF"));
        list.add(new Bus("з ринку", "Черкаси - Сокирне", "13:45 - 14:35", "b=712100&r=1479"));
        list.add(new ExtraBus("з вокзалу", "Черкаси - Будище", "14:25 - 15:30", "b=712000&r=87%CF"));
        list.add(new Bus("з ринку", "Черкаси - Сокирне", "15:45 - 16:50", "b=712100&r=257%CF"));
        list.add(new Bus("з ринку", "Черкаси - Сокирне", "16:45 - 17:40", "b=712100&r=150%CF"));
        list.add(new ExtraBus("з вокзалу", "Черкаси - Будище", "17:40 - 18:45", "b=712000&r=89%CF"));

        return list;
    }

    private ArrayList<Object> getListBusCherkasySmila() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Bus("302", "Черкаси - Шевченко", "06:10 - 07:15", "b=712000&r=226%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "06:30 - 07:30", "b=712000&r=153%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "06:50 - 07:55", "b=712000&r=227%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "07:15 - 08:15", "b=712000&r=155%CF"));

        list.add(new ExtraBus("", "Черкаси - Новомиргород", "07:40 - 08:24", "b=712000&r=703"));

        list.add(new Bus("302", "Черкаси - Шевченко", "07:55 - 08:55", "b=712000&r=397%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "08:15 - 09:00", "b=712000&r=43%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "08:25 - 09:30", "b=712000&r=137%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "08:35 - 09:35", "b=712000&r=399%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "08:55 - 10:00", "b=712000&r=4%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "09:10 - 10:10", "b=712000&r=157%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "09:35 - 10:40", "b=712000&r=228%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "09:55 - 10:55", "b=712000&r=159%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "10:15 - 11:15", "b=712000&r=401%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "10:35 - 11:15", "b=712000&r=45%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "10:55 - 11:55", "b=712000&r=403%CF"));

        list.add(new ExtraBus("", "Черкаси - Новомиргород", "11:00 - 11:44", "b=712000&r=2724"));

        list.add(new Bus("302", "Черкаси - Шевченко", "11:15 - 12:05", "b=712000&r=405%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "11:35 - 12:40", "b=712000&r=229%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "11:55 - 12:55", "b=712000&r=163%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "12:15 - 13:20", "b=712000&r=230%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "12:35 - 13:35", "b=712000&r=165%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "12:55 - 13:55", "b=712000&r=47%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "13:15 - 14:00", "b=712000&r=67%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "13:35 - 14:35", "b=712000&r=230%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "13:55 - 14:55", "b=712000&r=411%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "14:15 - 15:20", "b=712000&r=231%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "14:35 - 15:35", "b=712000&r=167%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "14:55 - 16:00", "b=712000&r=7%CF"));

        list.add(new ExtraBus("", "Черкаси - Новомиргород", "15:00 - 15:39", "b=712000&r=677"));

        list.add(new Bus("302", "Черкаси - Шевченко", "15:15 - 16:15", "b=712000&r=198%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "15:35 - 16:20", "b=712000&r=69%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "15:55 - 16:55", "b=712000&r=408%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "16:15 - 17:20", "b=712000&r=132%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "16:35 - 17:35", "b=712000&r=413%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "16:55 - 18:00", "b=712000&r=232%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "17:15 - 18:15", "b=712000&r=199%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "17:35 - 18:40", "b=712000&r=233%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "17:55 - 18:55", "b=712000&r=200%CF"));

        list.add(new ExtraBus("", "Черкаси - Новомиргород", "18:00 - 18:44", "b=712000&r=728"));

        list.add(new Bus("302", "Черкаси - Шевченко", "18:15 - 19:00", "b=712000&r=71%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "18:35 - 19:35", "b=712000&r=415%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "18:55 - 20:00", "b=712000&r=134%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "19:15 - 20:15", "b=712000&r=417%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "19:35 - 20:40", "b=712000&r=234%CF"));
        list.add(new Bus("302", "Черкаси - Шевченко", "20:05 - 21:10", "b=712000&r=235%CF"));

        return list;
    }

    private ArrayList<Object> getListBusSmilaCherkasy() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Bus("302", "Шевченко - Черкаси", "06:30 - 07:40", "b=710705&r=16%CF"));
        list.add(new Bus("302", "Шевченко - Черкаси", "06:55 - 08:00", "b=710705&r=5452"));
        list.add(new Bus("302", "Шевченко - Черкаси", "07:15 - 08:25", "b=710705&r=12%CF"));
        list.add(new Bus("302", "Шевченко - Черкаси", "07:35 - 08:55", "b=710705&r=5009"));

        list.add(new ExtraBus("", "Новомиргород - Черкаси", "07:45 - 08:30", "b=354500&r=723"));

        list.add(new Bus("302", "Шевченко - Черкаси", "07:55 - 09:00", "b=710705&r=5158"));
        list.add(new Bus("302", "Шевченко - Черкаси", "08:15 - 09:25", "b=710705&r=5005"));
        list.add(new Bus("302", "Шевченко - Черкаси", "08:35 - 09:40", "b=710705&r=5154"));
        list.add(new Bus("302", "Шевченко - Черкаси", "09:00 - 10:10", "b=710705&r=17%CF"));
        list.add(new Bus("302", "Шевченко - Черкаси", "09:25 - 10:30", "b=710705&r=5400"));
        list.add(new Bus("302", "Шевченко - Черкаси", "09:50 - 10:55", "b=710705&r=5402"));
        list.add(new Bus("302", "Шевченко - Черкаси", "10:15 - 11:25", "b=710705&r=5011"));
        list.add(new Bus("302", "Шевченко - Черкаси", "10:35 - 11:40", "b=710705&r=5166"));
        list.add(new Bus("302", "Шевченко - Черкаси", "10:55 - 12:05", "b=710705&r=5001"));
        list.add(new Bus("302", "Шевченко - Черкаси", "11:15 - 12:20", "b=710705&r=5156"));
        list.add(new Bus("302", "Шевченко - Черкаси", "11:35 - 12:40", "b=710705&r=18%CF"));
        list.add(new Bus("302", "Шевченко - Черкаси", "11:55 - 13:05", "b=710705&r=13%CF"));

        list.add(new ExtraBus("", "Новомиргород - Черкаси", "12:10 - 12:45", "b=354500&r=704"));

        list.add(new Bus("302", "Шевченко - Черкаси", "12:15 - 13:20", "b=710705&r=5404"));
        list.add(new Bus("302", "Шевченко - Черкаси", "12:35 - 13:45", "b=710705&r=5406"));
        list.add(new Bus("302", "Шевченко - Черкаси", "12:55 - 14:05", "b=710705&r=5006"));
        list.add(new Bus("302", "Шевченко - Черкаси", "13:15 - 14:20", "b=710705&r=60%CF"));
        list.add(new Bus("302", "Шевченко - Черкаси", "13:35 - 14:45", "b=710705&r=5002"));
        list.add(new Bus("302", "Шевченко - Черкаси", "13:55 - 15:00", "b=710705&r=5160"));
        list.add(new Bus("302", "Шевченко - Черкаси", "14:15 - 15:20", "b=710705&r=14%CF"));
        list.add(new Bus("302", "Шевченко - Черкаси", "14:35 - 15:45", "b=710705&r=25%CF"));
        list.add(new Bus("302", "Шевченко - Черкаси", "14:55 - 16:15", "b=710705&r=131%CF"));
        list.add(new Bus("302", "Шевченко - Черкаси", "15:15 - 16:20", "b=710705&r=5410"));
        list.add(new Bus("302", "Шевченко - Черкаси", "15:35 - 16:45", "b=710705&r=5010"));

        list.add(new ExtraBus("", "Новомиргород - Черкаси", "15:45 - 16:30", "b=354500&r=727"));

        list.add(new Bus("302", "Шевченко - Черкаси", "15:55 - 17:00", "b=710705&r=5164"));
        list.add(new Bus("302", "Шевченко - Черкаси", "16:15 - 17:25", "b=710705&r=5422"));
        list.add(new Bus("302", "Шевченко - Черкаси", "16:35 - 17:40", "b=710705&r=61%CF"));
        list.add(new Bus("302", "Шевченко - Черкаси", "16:55 - 18:00", "b=710705&r=15%CF"));
        list.add(new Bus("302", "Шевченко - Черкаси", "17:15 - 18:25", "b=710705&r=5412"));
        list.add(new Bus("302", "Шевченко - Черкаси", "17:35 - 18:55", "b=710705&r=133%CF"));
        list.add(new Bus("302", "Шевченко - Черкаси", "17:55 - 19:00", "b=710705&r=5419"));
        list.add(new Bus("302", "Шевченко - Черкаси", "18:15 - 19:20", "b=710705&r=5007"));
        list.add(new Bus("302", "Шевченко - Черкаси", "18:35 - 19:40", "b=710705&r=5168"));
        list.add(new Bus("302", "Шевченко - Черкаси", "18:55 - 20:00", "b=710705&r=5003"));

        list.add(new ExtraBus("", "Новомиргород - Черкаси", "19:00 - 19:40", "b=354500&r=678"));

        list.add(new Bus("302", "Шевченко - Черкаси", "19:15 - 20:20", "b=710705&r=62%CF"));
        list.add(new Bus("302", "Шевченко - Черкаси", "19:35 - 20:40", "b=710705&r=5417"));
        list.add(new Bus("302", "Шевченко - Черкаси", "20:05 - 21:10", "b=710705&r=63%CF"));
        list.add(new Bus("302", "Шевченко - Черкаси", "20:45 - 21:50", "b=710705&r=508%CF"));
        return list;
    }

    private ArrayList<Object> getListBusSokirnoCherkasy(){
        ArrayList<Object> list = new ArrayList<>();
        return list;
    }


    private ArrayList<Object> loadDataFromDbCherkasySmila() {
        ArrayList<Object> list;

        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm realm = Realm.getInstance(config);

        RealmResults<TrainCherkasySmilaRealm> listFromDb = realm.where(TrainCherkasySmilaRealm.class).findAll();

        list = new ArrayList<>();

        if (!list.contains(new UpdateTrain())) {
            list.add(0, new UpdateTrain());
        }
        for (TrainCherkasySmilaRealm train : listFromDb) {

            Train myTrain = new Train();
            myTrain.setTimeTo(train.getTimeTo());
            myTrain.setTimeFrom(train.getTimeFrom());
            myTrain.setNumber(train.getNumber());
            myTrain.setDirection(train.getDirection());
            myTrain.setTime(train.getTime());

            list.add(myTrain);
        }
        return list;
    }

    private ArrayList<Object> loadDataFromDbSmilaCherkasy() {
        ArrayList<Object> list;

        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm realm = Realm.getInstance(config);
        RealmResults<TrainSmilaCherkasyRealm> listFromDb = realm.where(TrainSmilaCherkasyRealm.class).findAll();

        list = new ArrayList<>();
        if (!list.contains(new UpdateTrain())) {
            list.add(0, new UpdateTrain());
        }
        for (TrainSmilaCherkasyRealm train : listFromDb) {
            Train myTrain = new Train();
            myTrain.setTimeTo(train.getTimeTo());
            myTrain.setTimeFrom(train.getTimeFrom());
            myTrain.setNumber(train.getNumber());
            myTrain.setDirection(train.getDirection());
            myTrain.setTime(train.getTime());

            list.add(myTrain);
        }
        return list;
    }

    public ArrayList<Object> loadDataByClick(int id) throws ExecutionException, InterruptedException {
        LoadedDetails loadedDetails = new LoadedDetails();

        switch (id) {
            case 1:
                ArrayList<Object> list;
                loadedDetails.execute(URL_PATH_TRAIN_CHERKASY_SMILA);
                list = loadedDetails.get();

                saveDataToDbCherkasySmila(list);
                return list;
            case 2:
                ArrayList<Object> list1;
                loadedDetails.execute(URL_PATH_TRAIN_SMILA_CHERKASY);
                list1 = loadedDetails.get();

                saveDataToDbSmilaCherkasy(list1);
                return list1;
        }
        return null;
    }

    private void saveDataToDbCherkasySmila(ArrayList<Object> list) {

        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm realm = Realm.getInstance(config);


        realm.beginTransaction();
        realm.delete(TrainCherkasySmilaRealm.class);

        for (Object train : list) {

            Train myTrain = (Train) train;
            TrainCherkasySmilaRealm trainCherkasySmila = new TrainCherkasySmilaRealm();

            trainCherkasySmila.setDirection(myTrain.getDirection());
            trainCherkasySmila.setNumber(myTrain.getNumber());
            trainCherkasySmila.setTime(myTrain.getTime());
            trainCherkasySmila.setTimeFrom(myTrain.getTimeFrom());
            trainCherkasySmila.setTimeTo(myTrain.getTimeTo());
            realm.insert(trainCherkasySmila);
            ;
        }

        realm.commitTransaction();
    }

    private void saveDataToDbSmilaCherkasy(ArrayList<Object> list) {
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm realm = Realm.getInstance(config);

        realm.beginTransaction();
        realm.delete(TrainSmilaCherkasyRealm.class);
        for (Object train : list) {

            Train myTrain = (Train) train;
            TrainSmilaCherkasyRealm trainSmilaCherkasy = new TrainSmilaCherkasyRealm();

            trainSmilaCherkasy.setDirection(myTrain.getDirection());
            trainSmilaCherkasy.setNumber(myTrain.getNumber());
            trainSmilaCherkasy.setTime(myTrain.getTime());
            trainSmilaCherkasy.setTimeFrom(myTrain.getTimeFrom());
            trainSmilaCherkasy.setTimeTo(myTrain.getTimeTo());
            realm.insert(trainSmilaCherkasy);
        }

        realm.commitTransaction();
    }


    private static class LoadedDetails extends AsyncTask<String, Void, ArrayList<Object>> {

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<Object> doInBackground(String... params) {
            ArrayList<Object> trains = null;
            String url = params[0];
            try {
                Document doc = Jsoup.connect(url).get();
                Elements data = doc.select("tbody").select("tr");

                trains = new ArrayList<>();

                ArrayList<String> parseData = new ArrayList<>();

                for (int i = 0; i < data.size(); i++) {

                    Elements data_1 = data.get(i).select("td");

                    parseData.addAll(data_1.eachText());

                    trains.add(new Train(parseData.get(0), parseData.get(1), parseData.get(2), parseData.get(3), parseData.get(4)));
                    parseData.clear();

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return trains;
        }

        @Override
        protected void onPostExecute(ArrayList<Object> list) {
            super.onPostExecute(list);
        }
    }

}
