package com.blog.ljtatum.cultured.activity.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface

class DialogUtils {

    private var dialog: AlertDialog? = null

    // click listener for default dialog
    private val defaultListener = DialogInterface.OnClickListener { _, _ -> dismissDialog() }

    /**
     * Method is used to dismiss dialog
     */
    private fun dismissDialog() {
        try {
            if (dialog?.isShowing == true) {
                dialog?.dismiss()
                dialog = null
            }
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
    }

    /**
     * Method is used to create AlertDialog with listener
     * <p>AlertDialog is a subclass of Dialog that can display one, two or three buttons</p>
     *
     * @param activity required to build / display the dialog
     * @param title the dialog title
     * @param message the dialog message
     * @param listener callback for positive button action
     * @return A subclass of Dialog that can display one, two or three buttons.
     */
    private fun createAlertDialog(
        activity: Activity, title: String, message: String?,
        listener: DialogInterface.OnClickListener = defaultListener
    ): AlertDialog? {
        dialog = AlertDialog.Builder(activity)
            .setTitle(title)
            .setCancelable(false)
            .setMessage(message)
            .setPositiveButton(android.R.string.ok, listener)
            .create()
        return dialog
    }

    /**
     * Create dialog with custom title and messages
     *
     * @param activity required to build / display the dialog
     * @param title the dialog title
     * @param message the dialog message
     * @param listener callback for positive button action
     */
    fun createOkDialog(
        activity: Activity,
        title: String,
        message: String,
        listener: DialogInterface.OnClickListener = defaultListener
    ) {
        if (!activity.isFinishing) {
            createAlertDialog(
                activity = activity,
                title = title,
                message = message,
                listener = listener
            )?.show()
        }
    }

    /**
     * Method is used to clear dialog resources
     *
     *<p>Call this method in onDestroy() in Activities using [DialogUtils] or onDetach() in
     * Fragments using [DialogUtils]</p>
     */
    fun dispose() {
        dialog = null
    }
}