package org.planteome.samara

import java.io.File

import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.scraper.ContentExtractors._
import net.ruippeixotog.scalascraper.model.{Element, Document}
import org.scalatest._

import scala.util.matching.Regex

object ParserGrinStatic extends ParserGrin with NameFinderStatic

class ParserGrin$Test extends FlatSpec with Matchers with NameFinderStatic with ParseTestUtil {

  "parsing descriptors page" should "generate a list of species ids" in {
    val doc: Document = parse("grin/descriptors.aspx")
    val ids: Iterable[Crop] = ParserGrinStatic.parseCropIds(doc)

    ids should not contain (-1)
    ids should contain(Crop(115))
    ids should contain(Crop(265))
  }

  "parsing descriptor page" should "generate a list of available descriptors" in {
    val doc: Document = parse("grin/cropdetail.aspx")
    val ids: Iterable[Descriptor] = ParserGrinStatic.parseAvailableDescriptorIdsForCropId(doc)

    ids should contain(Descriptor(115156))
    ids should contain(Descriptor(115159))
  }

  "parsing descriptor detail page" should "generate a list of (descriptor, study / environment) id pairs" in {
    val doc: Document = parse("grin/descriptordetail.aspx")
    val methods: Iterable[Method] = ParserGrinStatic.parseAvailableMethodsForDescriptor(doc)

    methods should contain(Method(descriptor = Descriptor(115156), id = 492154))
    methods should contain(Method(descriptor = Descriptor(115156), id = 492159))
  }

  "parsing method assession page" should "generate a list of (descriptor, study / environment) id pairs" in {
    val doc: Document = parse("grin/methodaccession.aspx")
    val accessionIds: Iterable[Int] = ParserGrinStatic.parseAvailableAccessionsForDescriptorAndMethod(doc)

    accessionIds should contain(1011492)
    accessionIds should contain(1022529)
  }

  "parsing assession detail page" should "result in a taxon id" in {
    val doc: Document = parse("grin/AccessionDetail.aspx")
    val taxonIds: Iterable[Int] = ParserGrinStatic.parseTaxonIdInAccessionDetails(doc)
    taxonIds should contain(23257)
  }

  "parsing assession observations page" should "list all observations for assession" in {
    val doc: Document = parse("grin/AccessionObservation.aspx")
    val observations: Iterable[(Int, Int, String)] = ParserGrinStatic.parseObservationsForAccession(doc)

    observations should contain((115156, 492154, "10"))
    observations should contain((115134, 492154, "6,6 - OTHER USE (ORNAMENTAL, ROOTSTOCK, GERMPLASM)"))
  }

  "parsing taxon page" should "return a taxon path" in {
    val doc: Document = parse("grin/taxonomydetail.aspx")
    val (scientificName, ranks) = ParserGrinStatic.parseTaxonPage(doc)

    scientificName should be("Malus platycarpa Rehder")
    ranks should contain(Taxon(name = "Malus", rank = "genus", id = 7215))
    ranks should contain(Taxon(name = "Rosaceae", rank = "family", id = 972))
  }

}