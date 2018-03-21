package com.example.biscuit.mydrawer

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
class ArticlesObjectResponse {

    @field:Element(name = "channel")
    var channel: Channel? = null

    @Root(name = "channel", strict = false)
    class Channel {

        @field:ElementList(name = "item", inline = true)
        var articles: ArrayList<Articles>? = null

        @field:Element(name= "image")
        var image: ImageArticle? = null

        @Root(name="image", strict = false)
        class ImageArticle {

            @field:Element(name = "url")
            var urlImage: String? = null
        }

    }

}
