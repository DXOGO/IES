package com.lab01.weather;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
<<<<<<< HEAD
=======

import java.util.Scanner;
>>>>>>> 2cf7c1ec938c8c47cbb0ee5db0cc8b251ad682f4
import java.util.logging.Logger;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

   // private static final int CITY_ID_AVEIRO = 1010500;
    /*
    loggers provide a better alternative to System.out.println
    https://rules.sonarsource.com/java/tag/bad-practice/RSPEC-106
     */
    private static final Logger logger = Logger.getLogger(WeatherStarter.class.getName());

<<<<<<< HEAD
    public static void main(String[] args) {
=======
    public static void  main(String[] args ) {
>>>>>>> 2cf7c1ec938c8c47cbb0ee5db0cc8b251ad682f4

        /*
        get a retrofit instance, loaded with the GSon lib to convert JSON into objects
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        String CITY_ID = args[0];

        IpmaService service = retrofit.create(IpmaService.class);
        Call<IpmaCityForecast> callSync = service.getForecastForACity(Integer.parseInt(CITY_ID));

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                logger.info( "\n\nThe max temperature for today is: " 
                    + forecast.getData().listIterator().next().getTMax() + "º\nThe min temperature for today is: " 
                    + forecast.getData().listIterator().next().getTMin() + "º\nPrecipitaion information: " 
                    + forecast.getData().listIterator().next().getPrecipitaProb() +"\n");
            } else {
                logger.info( "No results!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
