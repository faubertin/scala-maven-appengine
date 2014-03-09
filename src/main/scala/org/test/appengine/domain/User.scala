package org.test.appengine.domain

case class User(
        id: Option[String],
        username: String,
        email: String)