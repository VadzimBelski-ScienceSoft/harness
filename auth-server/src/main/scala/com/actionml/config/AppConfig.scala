package com.actionml.router.config

import com.typesafe.config.ConfigFactory
import net.ceedubs.ficus.Ficus._
import net.ceedubs.ficus.readers.ArbitraryTypeReader._
import net.ceedubs.ficus.readers.EnumerationReader._

/**
  *
  *
  * @author The ActionML Team (<a href="http://actionml.com">http://actionml.com</a>)
  * 29.01.17 19:09
  */
case class AppConfig(restServer: HttpServerConfig, actorSystem: ActorSystemConfig)
case class HttpServerConfig(
  host: String,
  port: Int,
  ssl: Boolean
)
case class ActorSystemConfig(
  name: String
)

object AppConfig{
  val config = ConfigFactory.load()

  def apply: AppConfig = new AppConfig(
    restServer = config.as[HttpServerConfig]("http-server"),
    actorSystem = config.as[ActorSystemConfig]("actor-system")
  )


}
