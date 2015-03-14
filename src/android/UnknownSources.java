package de.eits.cordova.unknownsources;

import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import android.content.Intent;
import android.provider.Settings.SettingNotFoundException;

public class UnknownSources extends CordovaPlugin {

	private static final String LOG_TAG = "UnknownSourcesPlugin";

	@Override
	public void pluginInitialize() {
        Log.i(LOG_TAG, "Plugin initialized.");
    }

	@Override
    public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext) throws JSONException {

        Log.i(LOG_TAG, "execute called with action: " + action);

        if (action.equals("isUnknownSourcesActivated")) {
            JSONObject r = new JSONObject();
            r.put("activated", isUnknownSourcesActivated());
            callbackContext.success(r);
            return true;
        }
        else if (action.equals("goToUnknownSourcesSettings")) {
            goToUnknownSourcesSettings();
            callbackContext.success();
            return true;
        }
        return false;
	}

	public boolean isUnknownSourcesActivated() {
        try {
            int unknownSourcesActivated = android.provider.Settings.Secure.getInt(this.cordova.getActivity().getContentResolver(),
                    android.provider.Settings.Secure.INSTALL_NON_MARKET_APPS);
            return unknownSourcesActivated == 1;
        } catch (SettingNotFoundException e) {
            e.printStackTrace();
            return true;
        }
    }

	public void goToUnknownSourcesSettings() {
        Intent intentSettings = new Intent();
        int apiVersion = android.os.Build.VERSION.SDK_INT;
        if (apiVersion > 13) {
            intentSettings.setAction(android.provider.Settings.ACTION_SECURITY_SETTINGS);
        } else {
            intentSettings.setAction(android.provider.Settings.ACTION_APPLICATION_SETTINGS);
        }
        this.cordova.getActivity().startActivity(intentSettings);
	}

}
