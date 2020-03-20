package com.example.myapplication.main

import com.example.myapplication.base.BasePresenter
import com.example.myapplication.base.BaseView

interface MainContract {

    interface View : BaseView {

    }

    interface Presenter : BasePresenter<View> {

    }

}