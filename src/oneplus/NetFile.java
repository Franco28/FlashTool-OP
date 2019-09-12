/*
 * Copyright 2019 Franco.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package oneplus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;

/**
 * @author intlink
 */
public class NetFile {

    private File dest;
    private String source;
    private long size;
    /**
     * @param to the file which contents you would like to get fetched from net.
     * @param from the source URL (as String).
     * @param weight the expected exact size, if set to -1 will be infinite (long max-value).
     */
    public NetFile(File to, String from, long weight) {
        this.dest=to;
	this.source=from;
        if(weight==-1){
            this.size=Long.MAX_VALUE;
        } else {
            this.size=weight;
        }
    }

    /**
     * Changes the destination file. Also is deprecated.
     * @param to the file which contents you would like to get fetched from net.
     * @see #reconstruct
     */
    @Deprecated
    public void changeDestination(File to) {
       this.dest=to;
    }
    /**
     * Changes the source. Also is deprecated.
     * @param from the source URL (as String).
     * @see #reconstruct
     */
    @Deprecated
    public void changeSource(String from) {
       this.source=from;
    }
    /**
     * Reconstructs this class.
     * @param to the file which contents you would like to get fetched from net.
     * @param from the source URL (as String).
     * @param weight the expected exact size, if set to -1 will be infinite (long max-value).
     */
    public void reconstruct(File to, String from, long weight) {
        this.dest=to;
	this.source=from;
        if(weight==-1){
            this.size=Long.MAX_VALUE;
        } else {
            this.size=weight;
        }
    }
    /**
     * Downloads the file
     * @return true if succeed, false if not.
     */
    public boolean load() {
        try {
        URL src = new URL(this.source);
        FileOutputStream output = new FileOutputStream(this.dest.getAbsolutePath());
        output.getChannel().transferFrom(Channels.newChannel(src.openStream()), 0, Long.MAX_VALUE);
            return this.dest.exists();
            
        } catch (IOException ex) {
            return false;
        }
    }
}
