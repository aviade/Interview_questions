package com.samples.towerofhanoi;

/**
 * Created by avezra on 7/4/2017.
 */
public class MoveDiskException extends Throwable {
    public MoveDiskException(Integer targetDisk, Integer sourceDisk) {
        super(String.format("Can't put %d on top of %d", sourceDisk, targetDisk));
    }
}
