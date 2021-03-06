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

package com.actionml.admin

import cats.data.Validated
import cats.data.Validated.Invalid
import com.actionml.core.template.Engine
import com.actionml.core.validate.{WrongParams, ValidateError}
import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.LazyLogging

/** Handles commands or Rest requests that are system-wide, not the concern of a single Engine */
abstract class Administrator extends LazyLogging {

  type EngineId = String

  lazy val config: Config = ConfigFactory.load()

  // engine management
  def getEngine(engineId: EngineId): Option[Engine]
  def addEngine(json: String): Validated[ValidateError, EngineId]
  def removeEngine(engineId: EngineId): Validated[ValidateError, Boolean]
  def updateEngine(
    engineId: EngineId,
    engineJson: Option[String] = None,
    dataDelete: Boolean = false,
    force: Boolean = false,
    input: Option[String] = None): Validated[ValidateError, Boolean]
  def list(resourceType: String): Validated[ValidateError, String]

  // startup and shutdown
  def init(): Administrator = this
  def start(): Administrator = this
  def stop(): Unit = {}

}
