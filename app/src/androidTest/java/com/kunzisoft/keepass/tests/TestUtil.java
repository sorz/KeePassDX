/*
 * Copyright 2017 Brian Pellin, Jeremy Jamet / Kunzisoft.
 *
 * This file is part of KeePass DX.
 *
 *  KeePass DX is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  KeePass DX is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with KeePass DX.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.kunzisoft.keepass.tests;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class TestUtil {
    private static final File sdcard = Environment.getExternalStorageDirectory();

    public static void extractKey(Context ctx, String asset, String target) throws Exception {

        InputStream key = ctx.getAssets().open(asset, AssetManager.ACCESS_STREAMING);

        FileOutputStream keyFile = new FileOutputStream(target);
        while (true) {
            byte[] buf = new byte[1024];
            int read = key.read(buf);
            if ( read == -1 ) {
                break;
            } else {
                keyFile.write(buf, 0, read);
            }
        }

        keyFile.close();

    }

    public static String getSdPath(String filename) {
        File file = new File(sdcard, filename);
        return file.getAbsolutePath();
    }
}
