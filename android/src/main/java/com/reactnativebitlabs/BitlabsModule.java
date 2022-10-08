package com.reactnativebitlabs;

import android.content.Context;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import java.util.HashMap;
import java.util.Map;

import ai.bitlabs.sdk.BitLabs;


@ReactModule(name = BitlabsModule.NAME)
public class BitlabsModule extends ReactContextBaseJavaModule {
    public static final String NAME = "Bitlabs";

    public BitlabsModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void initBitLabsSDK(String token, String userId, String playerId){
      BitLabs BitLabsSDK = BitLabs.INSTANCE;
      Context context = getReactApplicationContext();
      BitLabsSDK.init(context, token, userId);
      Map<String, Object> tags = new HashMap<>();
      tags.put("playerId", playerId);
      BitLabsSDK.setTags(tags);
    }

    @ReactMethod
    public void show(){
      BitLabs BitLabsSDK = BitLabs.INSTANCE;
      Context context = getReactApplicationContext();
//      BitLabsSDK.show(context);
    }

    @ReactMethod
    public void showOfferWall(){
      BitLabs bitLabsSDK = BitLabs.INSTANCE;
      Context context = getReactApplicationContext();
      bitLabsSDK.launchOfferWall(context);
    }

    @ReactMethod
    public void hasSurveys(Promise promise){
      BitLabs BitLabsSDK = BitLabs.INSTANCE;
//      BitLabsSDK.(promise::resolve, promise::reject);
    }
}
