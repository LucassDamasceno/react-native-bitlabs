package com.reactnativebitlabs;

import android.content.Context;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import ai.bitlabs.sdk.BitLabsSDK;


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
    public void initBitLabsSDK(String token, String userId){
      Context context = getReactApplicationContext();
      BitLabsSDK.Companion.init(context, token, userId);
    }

    @ReactMethod
    public void show(){
      Context context = getReactApplicationContext();
      BitLabsSDK.Companion.show(context);
    }

    @ReactMethod
    public void hasSurveys(Promise promise){
      BitLabsSDK.Companion.hasSurveys(promise::resolve, promise::reject);
    }
}
