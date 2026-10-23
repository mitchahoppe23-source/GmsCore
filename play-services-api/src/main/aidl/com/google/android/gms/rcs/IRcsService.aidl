/*
 * SPDX-License-Identifier: Apache-2.0
 */

package com.google.android.gms.rcs;

import android.os.Bundle;
import com.google.android.gms.rcs.IRcsCallbacks;

interface IRcsService {
    void registerRcsCallbacks(IRcsCallbacks callbacks) = 0;
    void unregisterRcsCallbacks(IRcsCallbacks callbacks) = 1;
    int getRcsStatus() = 2;
    void requestRcsConfiguration(in Bundle options, IRcsCallbacks callbacks) = 3;
}
