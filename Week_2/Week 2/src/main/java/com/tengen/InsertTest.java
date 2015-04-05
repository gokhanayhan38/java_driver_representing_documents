/*
 * Copyright (c) 2008 - 2013 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.tengen;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;
import java.util.Arrays;

public class InsertTest {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB courseDB = client.getDB("course"); // database seciyoruz, clientdan getDB metodu ile alıyoruz. course bizim db mizin adı.
        DBCollection collection = courseDB.getCollection("insertTest"); // bir koleksiyona ihtiyacımız var.
        //colectionu courseDB den alıyoruz.collecitona da insertTest adını veriyoruz.

        collection.drop(); // bunu buraya yazmasının sebebi ornegi gercekleştirirken enson ekleneni gorebilmek icin eski documanları siliyor.

        DBObject doc = new BasicDBObject().append("x", 1); //insertedilecek bir onject e ihtiyacımız var adı doc olsun.
        DBObject doc2 = new BasicDBObject().append("x", 2);

        //collection.insert(doc); // bir documanı eklemek icin kullanılıyor.
        collection.insert(Arrays.asList(doc,doc2)); // 2 documanıda birden eklemek icin kullanılıyor

        //Not: eger collection.insert(doc); bunu 2 kere yazarsak mongoexceptionduplicatekey gibi bir hata alırız.yani 1. kabul 2. si failed olur.
    }
}
