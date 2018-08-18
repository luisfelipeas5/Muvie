package br.com.mvpbase.viewstatus

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class FragmentStatus(val fragment: Fragment): ActivityStatus(fragment.activity as AppCompatActivity)