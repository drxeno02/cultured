package com.blog.ljtatum.cultured.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blog.ljtatum.cultured.R
import com.blog.ljtatum.cultured.activity.utils.DialogUtils
import com.blog.ljtatum.cultured.adapter.DeviceAdapter

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // views
    private var tvHeaderSectionPopularBrands: TextView? = null
    private var tvHeaderSectionAllDevices: TextView? = null
    private var ivDeviceAmazon: ImageView? = null
    private var ivDevicePhilips: ImageView? = null
    private var ivDeviceKasa: ImageView? = null
    private var ivDeviceWemo: ImageView? = null

    // adapter
    private var deviceAdapter: DeviceAdapter? = null
    private var rvDevices: RecyclerView? = null

    // dialog
    private var dialog: DialogUtils? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hw_a_layout)

        // instantiate views
        initializeViews()
        initializeHandlers()
    }

    /**
     * Method is used to instantiate views
     */
    private fun initializeViews() {
        // initialize views and set values
        val header: TextView = findViewById(R.id.tv_header_title)
        header.text = resources.getString(R.string.title_setup)
        val headerSectionPopularBrands: LinearLayout = findViewById(R.id.rl_header_section_popular_brands)
        val headerSectionAllDevices: LinearLayout = findViewById(R.id.rl_header_section_all_devices)
        tvHeaderSectionPopularBrands = headerSectionPopularBrands.findViewById(R.id.tv_header_section_title)
        tvHeaderSectionAllDevices = headerSectionAllDevices.findViewById(R.id.tv_header_section_title)
        tvHeaderSectionPopularBrands?.text = resources.getString(R.string.title_popular_brands)
        tvHeaderSectionAllDevices?.text = resources.getString(R.string.title_all_devices)
        ivDeviceAmazon = findViewById(R.id.iv_device_amazon)
        ivDevicePhilips = findViewById(R.id.iv_device_philips)
        ivDeviceKasa = findViewById(R.id.iv_device_kasa)
        ivDeviceWemo = findViewById(R.id.iv_device_wemo)

        // initialize dialog
        dialog = DialogUtils()

        // initialize adapter
        rvDevices = findViewById(R.id.rv_device_items)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvDevices?.layoutManager = layoutManager
        rvDevices?.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        // retrieve list of devices locally
        val devices = resources.getStringArray(R.array.array_all_devices)
        // set adapter
        deviceAdapter = DeviceAdapter(
            this,
            devices.toList<String>()
        )
        rvDevices?.adapter = deviceAdapter
    }

    /**
     * Method is used to set click listeners
     */
    private fun initializeHandlers() {
        ivDeviceAmazon?.setOnClickListener(this)
        ivDevicePhilips?.setOnClickListener(this)
        ivDeviceKasa?.setOnClickListener(this)
        ivDeviceWemo?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.iv_device_amazon -> {
                dialog?.createOkDialog(
                    this,
                    getString(R.string.dialog_title),
                    getString(R.string.dialog_message, getString(R.string.amazon_echo))
                )
            }
            R.id.iv_device_philips -> {
                dialog?.createOkDialog(
                    this,
                    getString(R.string.dialog_title),
                    getString(R.string.dialog_message, getString(R.string.philips_hue))
                )
            }
            R.id.iv_device_kasa -> {
                dialog?.createOkDialog(
                    this,
                    getString(R.string.dialog_title),
                    getString(R.string.dialog_message, getString(R.string.kasa))
                )
            }
            R.id.iv_device_wemo -> {
                dialog?.createOkDialog(
                    this,
                    getString(R.string.dialog_title),
                    getString(R.string.dialog_message, getString(R.string.wemo))
                )
            }
        }
    }
}