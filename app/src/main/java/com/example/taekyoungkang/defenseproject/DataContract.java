package com.example.taekyoungkang.defenseproject;

import android.provider.BaseColumns;

public class DataContract {
    private DataContract(){}

    public static class Data implements BaseColumns {
        public static final String TABLE_NAME = "post";
        public static final String TITLE = "title";
        public static final String NAME = "name";
        public static final String LOCATION = "location";
        public static final String CONTENTS = "contents";
    }
}
