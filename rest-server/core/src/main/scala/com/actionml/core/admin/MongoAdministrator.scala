/*
 * Copyright ActionML, LLC under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.actionml.core.admin

import cats.data.Validated
import cats.data.Validated.Valid
import com.actionml.core.storage.Mongo
import com.actionml.core.template.Engine
import com.actionml.core.validate.ValidateError

class MongoAdministrator() extends Administrator( new Mongo ) {


  def add(engine: Engine): Validated[ValidateError, Boolean] = {
    Valid(true)
  }

  def remove(engine: Engine): Validated[ValidateError, Boolean] = {
    Valid(true)
  }

}