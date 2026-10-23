/*
 * SPDX-License-Identifier: Apache-2.0
 */

package com.google.android.gms.rcs;

import android.os.Bundle;

interface IRcsCallbacks {
    void onStatusChanged(int statusCode, in Bundle details) = 0;
    void onConfigurationUpdated(in Bundle config) = 1;
}
