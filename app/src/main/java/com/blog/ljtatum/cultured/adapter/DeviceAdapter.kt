package com.blog.ljtatum.cultured.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.blog.ljtatum.cultured.R

class DeviceAdapter(
    private val context: Context,
    private var devices: List<String> = emptyList()
) : RecyclerView.Adapter<DeviceAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_device, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // set values
        holder.tvDevice.text = devices[position]
        // set icons
        when {
            devices[position] == context.resources.getString(R.string.amazon_echo) -> {
                holder.ivIcon.background = ContextCompat.getDrawable(context, R.drawable.amazon_echo_icon)
            }
            devices[position] == context.resources.getString(R.string.light) -> {
                holder.ivIcon.background = ContextCompat.getDrawable(context, R.drawable.light_icon)
            }
            devices[position] == context.resources.getString(R.string.plug) -> {
                holder.ivIcon.background = ContextCompat.getDrawable(context, R.drawable.devices_icon)
            }
            devices[position] == context.resources.getString(R.string.device_switch) -> {
                holder.ivIcon.background = ContextCompat.getDrawable(context, R.drawable.switch_icon)
            }
            else -> {
                // no-op
            }
        }
    }

    override fun getItemCount(): Int {
        return devices.size
    }

    /**
     * Method is used to update device data
     *
     * @param devices List of devices to display
     */
    fun updateData(devices: List<String>) {
        this.devices = devices
        // notify any registered observers that the data set has changed
        notifyDataSetChanged()
    }

    /**
     * View holder class
     *
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView
     */
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivIcon: ImageView = itemView.findViewById(R.id.iv_icon)
        val tvDevice: TextView = itemView.findViewById(R.id.tv_device)
    }
}