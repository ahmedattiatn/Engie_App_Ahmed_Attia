package ahmedattia.engieapplicationbyahmedatia.network;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Map;

import ahmedattia.engieapplicationbyahmedatia.application.Singleton;
import ahmedattia.engieapplicationbyahmedatia.model.User;
import ahmedattia.engieapplicationbyahmedatia.session.Session_KEY;
import ahmedattia.engieapplicationbyahmedatia.ui.UserAccountActivity;
import ahmedattia.engieapplicationbyahmedatia.utils.SharedPreference;

/**
 * Created by Ahmed Attia on 06/05/2017.
 */

public class GetUserFromServer {


    static String JSON_URL = "http://jsonplaceholder.typicode.com/users";

    public static void sendUser(final String mail_text, final Context context) {
        final RequestQueue requestQueue = com.android.volley.toolbox.Volley.newRequestQueue(context);
        final SharedPreference sharedPreference = new SharedPreference();
        StringRequest stringrequest = new StringRequest(Request.Method.POST, JSON_URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        JSONParser parser = new JSONParser();
                        User user;
                        try {
                            JSONObject json = (JSONObject) parser.parse(response);
                            user = new User(json.get("email").toString(), json.get("id").toString());
                            sharedPreference.save(context, user.getMail(), Session_KEY.PREFS_KEY_MAIL);
                            sharedPreference.save(context, user.getID(), Session_KEY.PREFS_KEY_ID);
                            Intent intent = new Intent(context, UserAccountActivity.class);
                            context.startActivity(intent);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        requestQueue.stop();

                        Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", mail_text);
                return params;
            }
        };

        Singleton.getInstance(context).addToRequestQueue(stringrequest);

    }

}
