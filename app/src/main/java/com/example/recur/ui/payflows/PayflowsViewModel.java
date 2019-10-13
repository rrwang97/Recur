package com.example.recur.ui.payflows;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PayflowsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PayflowsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is payflows fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}