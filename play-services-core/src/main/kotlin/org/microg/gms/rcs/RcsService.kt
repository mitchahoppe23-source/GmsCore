/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.microg.gms.rcs

import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import com.google.android.gms.rcs.IRcsCallbacks
import com.google.android.gms.rcs.IRcsService

class RcsService : Service() {

    private val binder = object : IRcsService.Stub() {
        override fun registerRcsCallbacks(callbacks: IRcsCallbacks?) {
            Log.d(TAG, "registerRcsCallbacks called")
        }

        override fun unregisterRcsCallbacks(callbacks: IRcsCallbacks?) {
            Log.d(TAG, "unregisterRcsCallbacks called")
        }

        override fun getRcsStatus(): Int {
            Log.d(TAG, "getRcsStatus called")
            // Return 1 (CONNECTED / AVAILABLE) instead of API_DISABLED
            return 1
        }

        override fun requestRcsConfiguration(options: Bundle?, callbacks: IRcsCallbacks?) {
            Log.d(TAG, "requestRcsConfiguration called")
            callbacks?.onStatusChanged(1, Bundle.EMPTY)
        }
    }

    override fun onBind(intent: Intent?): IBinder {
        Log.d(TAG, "onBind action: ${intent?.action}")
        return binder
    }

    companion object {
        private const val TAG = "GmsRcsService"
    }
}
