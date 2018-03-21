package com.example.biscuit.mydrawer

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name ="item", strict = false)
class Articles {

    @field:Element(name = "title")
    var title: String? = null

    @field:Element(name = "description")
    var description: String? = null

    @set:Element(name = "link")
    @get:Element(name = "link")
    var link: String? = null

    var urlImage: String? = null

}
