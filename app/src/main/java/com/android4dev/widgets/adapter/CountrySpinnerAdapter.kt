package com.android4dev.widgets.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.android4dev.widgets.R
import com.android4dev.widgets.model.CountryModel
import kotlinx.android.synthetic.main.list_item_country_name.view.*

/***
 * @author Lokesh Desai (Android4Dev)
 * This class will render single items into spinner
 */
class CountrySpinnerAdapter(val context: Context) : BaseAdapter() {

    var listOfCountry: MutableList<CountryModel> = mutableListOf()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflateView =
            LayoutInflater.from(context).inflate(R.layout.list_item_country_name, parent, false)
        inflateView.textCountryName.text = listOfCountry[position].countryName
        return inflateView
    }

    override fun getItem(position: Int): Any {
        return listOfCountry[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listOfCountry.size
    }
}