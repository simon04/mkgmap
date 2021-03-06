/*
 * Copyright (C) 2010-2012.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 3 or
 * version 2 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 */

package uk.me.parabola.mkgmap.reader.osm;

import java.util.concurrent.atomic.AtomicLong;

public class FakeIdGenerator {

	private static final long START_ID = 1L << 62;
	
	private static final AtomicLong fakeId = new AtomicLong(START_ID);

	private static long startId = START_ID;
	
	/**
	 * Change the first id that is returned by this generator. The method must 
	 * be called <b>before</b> the first call of {@link #makeFakeId()}.
	 * @param firstFakeId the first id returned by this generator 
	 */
	public static void setStartId(long firstFakeId) {
		fakeId.set(firstFakeId);
		startId = firstFakeId;
	}
	
	/**
	 * Retrieves a unique id that can be used to fake OSM ids.
	 * 
	 * @return a unique id
	 */
	public static long makeFakeId() {
		long id = fakeId.incrementAndGet(); 
//				if (4611686018427394038L == id){
//					long dd = 4;
//				}
		return id;
	}

	public static boolean isFakeId(long id) {
		return id >= startId;
	}
	
}
