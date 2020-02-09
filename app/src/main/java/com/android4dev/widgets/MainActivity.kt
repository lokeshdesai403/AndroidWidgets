package com.android4dev.widgets

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android4dev.widgets.adapter.CountrySpinnerAdapter
import com.android4dev.widgets.base.BaseActivity
import com.android4dev.widgets.model.CountryModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var listOfCountry: MutableList<CountryModel>
    private lateinit var countrySpinnerAdapter: CountrySpinnerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        listOfCountry = mutableListOf()
        listOfCountry = generateDummyCountryList()

        setUpSpinnerAdapter()
    }

    private fun setUpSpinnerAdapter() {
        countrySpinnerAdapter = CountrySpinnerAdapter(this@MainActivity)
        countrySpinnerAdapter.listOfCountry = listOfCountry
        spinnerCountry.adapter = countrySpinnerAdapter

//        val stringAdapter = ArrayAdapter<String>(
//            this@MainActivity,
//            android.R.layout.simple_spinner_item,
//            resources.getStringArray(R.array.array_country)
//        )
//        spinnerCountry.adapter = stringAdapter

        spinnerCountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    this@MainActivity,
                    listOfCountry[position].countryName.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

    private fun generateDummyCountryList(): MutableList<CountryModel> {
        val listOfCountry = mutableListOf<CountryModel>()

        var countryModel = CountryModel("India")
        listOfCountry.add(countryModel)

        countryModel = CountryModel("USA")
        listOfCountry.add(countryModel)

        countryModel = CountryModel("Russia")
        listOfCountry.add(countryModel)

        countryModel = CountryModel("China")
        listOfCountry.add(countryModel)

        countryModel = CountryModel("Bangladesh")
        listOfCountry.add(countryModel)

        countryModel = CountryModel("Srilanka")
        listOfCountry.add(countryModel)

        return listOfCountry
    }

}
