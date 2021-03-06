package org.planteome.samara

import net.ruippeixotog.scalascraper.model.Document
import org.scalatest._


object ParserApsnetStatic$ extends ParserApsnet with TermFinderStatic

object expectedCitations {
  val alfalfa = "D. A. Samac, L. H. Rhodes, and W. O. Lamp, primary collators (Last update: 6/25/14). Diseases of Alfalfa (Medicago sativa L.). The American Phytopathological Society."
  val peachAndNectarine = "J. K. Uyemoto, J. M. Ogawa, and B. A. Jaffee, primary collators; updated by J. E. Adaskaveg, S. W. Scott, and H. Scherm (last update 5/23/01). Diseases of Peach and Nectarine Peach: Prunus persica (L.) Batsch Nectarine: P. persica var. nucipersica (Suckow) C.K. Schneid.. The American Phytopathological Society."
}

object expectedHosts {
  val verbatimPeachHost: String = "Diseases of Peach and Nectarine Peach: Prunus persica (L.) Batsch Nectarine: P. persica var. nucipersica (Suckow) C.K. Schneid."
}

class ParserApsnet$Test extends FlatSpec with Matchers with TermFinderStatic with ParseTestUtil {

  "Parsing Alfalfa" should "result in pathogen-host interactions for disease" in {
    val doc: Document = parse("apsnet/Alfalfa.aspx")
    val interactions: Iterable[Disease] = ParserApsnetStatic$.parse(doc)

    interactions should contain(Disease(name = "Alfalfa witches’-broom",
      verbatimPathogen = "‘Candidatus Phytoplasma asteris’",
      pathogen = "Candidatus Phytoplasma asteris",
      pathogenId = "id[Candidatus Phytoplasma asteris]",
      verbatimHost = "Diseases of Alfalfa (Medicago sativa L.)",
      host = "Medicago sativa L.",
      hostId = "id[Medicago sativa L.]",
      hostPartName = "Alfalfa witches’-broom",
      hostPartId = "id[Alfalfa witches’-broom]",
      citation = expectedCitations.alfalfa))

    interactions should contain(Disease(name = "Red clover vein mosaic",
      verbatimPathogen = "Red clover vein mosaic virus (RCVMV)",
      pathogen = "Red clover vein mosaic virus (RCVMV)",
      pathogenId = "id[Red clover vein mosaic virus (RCVMV)]",
      verbatimHost = "Diseases of Alfalfa (Medicago sativa L.)",
      host = "Medicago sativa L.",
      hostId = "id[Medicago sativa L.]",
      hostPartName = "Red clover vein mosaic",
      hostPartId = "id[Red clover vein mosaic]",
      citation = expectedCitations.alfalfa))
  }

  "Parsing Peach and Nectarine" should "result in pathogen-host interactions for disease" in {
    parsePeaches should contain(Disease(name = "Bacterial canker",
      verbatimPathogen = "Pseudomonas syringae pv. syringae van Hall 1902",
      pathogen = "Pseudomonas syringae pv. syringae van Hall 1902",
      pathogenId = "id[Pseudomonas syringae pv. syringae van Hall 1902]",
      verbatimHost = expectedHosts.verbatimPeachHost,
      host = "Prunus persica",
      hostId = "id[Prunus persica]",
      hostPartName = "Bacterial canker",
      hostPartId = "id[Bacterial canker]",
      citation = expectedCitations.peachAndNectarine))
  }

  "Parsing Peach and Nectarine" should "result in pathogen-host interactions for disease 2" in {
    parsePeaches should contain(Disease(name = "Bacterial canker",
      verbatimPathogen = "Pseudomonas syringae pv. syringae van Hall 1902",
      pathogen = "Pseudomonas syringae pv. syringae van Hall 1902",
      pathogenId = "id[Pseudomonas syringae pv. syringae van Hall 1902]",
      verbatimHost = expectedHosts.verbatimPeachHost,
      host = "Prunus persica var. nucipersica",
      hostId = "id[Prunus persica var. nucipersica]",
      hostPartName = "Bacterial canker",
      hostPartId = "id[Bacterial canker]",
      citation = expectedCitations.peachAndNectarine))
  }

  "Parsing Peach and Nectarine" should "result in pathogen-host interactions for disease 3" in {
    parsePeaches should contain(Disease(name = "Bacterial canker",
      verbatimPathogen = "Pseudomonas syringae pv. syringae van Hall 1902",
      pathogen = "Pseudomonas syringae pv. syringae van Hall 1902",
      pathogenId = "id[Pseudomonas syringae pv. syringae van Hall 1902]",
      verbatimHost = expectedHosts.verbatimPeachHost,
      host = "Prunus persica",
      hostId = "id[Prunus persica]",
      hostPartName = "Bacterial canker",
      hostPartId = "id[Bacterial canker]",
      citation = expectedCitations.peachAndNectarine))
  }

  "Parsing Peach and Nectarine" should "result in pathogen-host interactions for disease 4" in {
    parsePeaches should contain(Disease(name = "Bacterial canker",
      verbatimPathogen = "Pseudomonas syringae pv. syringae van Hall 1902",
      pathogen = "Pseudomonas syringae pv. syringae van Hall 1902",
      pathogenId = "id[Pseudomonas syringae pv. syringae van Hall 1902]",
      verbatimHost = expectedHosts.verbatimPeachHost,
      host = "Prunus persica var. nucipersica",
      hostId = "id[Prunus persica var. nucipersica]",
      hostPartName = "Bacterial canker",
      hostPartId = "id[Bacterial canker]",
      citation = expectedCitations.peachAndNectarine))
  }

  "Parsing Peach and Nectarine" should "result in pathogen-host interactions for disease 5" in {
    val interactions: Iterable[Disease] = parsePeaches

    interactions should contain(Disease(name = "Green fruit rot",
      verbatimPathogen = "Monilinia fructicola (G. Wint.) Honey",
      pathogen = "Monilinia fructicola (G. Wint.) Honey",
      pathogenId = "id[Monilinia fructicola (G. Wint.) Honey]",
      verbatimHost = expectedHosts.verbatimPeachHost,
      host = "Prunus persica",
      hostId = "id[Prunus persica]",
      hostPartName = "Green fruit rot",
      hostPartId = "id[Green fruit rot]",
      citation = expectedCitations.peachAndNectarine))
  }

  "Parsing Peach and Nectarine" should "result in pathogen-host interactions for disease 6" in {
    val interactions: Iterable[Disease] = parsePeaches


    interactions should contain(Disease(name = "Green fruit rot",
      verbatimPathogen = "Monilinia fructicola (G. Wint.) Honey",
      pathogen = "Monilinia fructicola (G. Wint.) Honey",
      pathogenId = "id[Monilinia fructicola (G. Wint.) Honey]",
      verbatimHost = expectedHosts.verbatimPeachHost,
      host = "Prunus persica var. nucipersica",
      hostId = "id[Prunus persica var. nucipersica]",
      hostPartName = "Green fruit rot",
      hostPartId = "id[Green fruit rot]",
      citation = expectedCitations.peachAndNectarine))
  }

  "Parsing Peach and Nectarine" should "result in pathogen-host interactions for disease 7" in {
    val interactions: Iterable[Disease] = parsePeaches


    interactions should contain(Disease(name = "Green fruit rot",
      verbatimPathogen = "M. laxa (Aderhold & Ruhland) Honey",
      pathogen = "Monilinia laxa (Aderhold & Ruhland) Honey",
      pathogenId = "id[Monilinia laxa (Aderhold & Ruhland) Honey]",
      verbatimHost = expectedHosts.verbatimPeachHost,
      host = "Prunus persica",
      hostId = "id[Prunus persica]",
      hostPartName = "Green fruit rot",
      hostPartId = "id[Green fruit rot]",
      citation = expectedCitations.peachAndNectarine))
  }

  "Parsing Peach and Nectarine" should "result in pathogen-host interactions for disease 8" in {
    parsePeaches should contain(Disease(name = "Green fruit rot",
      verbatimPathogen = "M. laxa (Aderhold & Ruhland) Honey",
      pathogen = "Monilinia laxa (Aderhold & Ruhland) Honey",
      pathogenId = "id[Monilinia laxa (Aderhold & Ruhland) Honey]",
      verbatimHost = expectedHosts.verbatimPeachHost,
      host = "Prunus persica var. nucipersica",
      hostId = "id[Prunus persica var. nucipersica]",
      hostPartName = "Green fruit rot",
      hostPartId = "id[Green fruit rot]",
      citation = expectedCitations.peachAndNectarine))
  }

  "Parsing Peach and Nectarine" should "result in pathogen-host interactions for disease 9" in {
    parsePeaches should contain(Disease(name = "Line pattern",
      verbatimPathogen = "genus Ilarvirus, Prunus necrotic ringspot virus (PNRSV)",
      pathogen = "Prunus necrotic ringspot virus",
      pathogenId = "id[Prunus necrotic ringspot virus]",
      verbatimHost = expectedHosts.verbatimPeachHost,
      host = "Prunus persica",
      hostId = "id[Prunus persica]",
      hostPartName = "Line pattern",
      hostPartId = "id[Line pattern]",
      citation = expectedCitations.peachAndNectarine))
  }

  "Parsing Peach and Nectarine" should "result in pathogen-host interactions for disease 10" in {
    parsePeaches should contain(Disease(name = "Line pattern",
      verbatimPathogen = "genus Ilarvirus, Prunus necrotic ringspot virus (PNRSV)",
      pathogen = "Prunus necrotic ringspot virus",
      pathogenId = "id[Prunus necrotic ringspot virus]",
      verbatimHost = expectedHosts.verbatimPeachHost,
      host = "Prunus persica var. nucipersica",
      hostId = "id[Prunus persica var. nucipersica]",
      hostPartName = "Line pattern",
      hostPartId = "id[Line pattern]",
      citation = expectedCitations.peachAndNectarine))

  }

  "Parsing Peach and Nectarine" should "result in pathogen-host interactions for disease 11" in {
    parsePeaches should contain(Disease(name = "Rosette and decline",
      verbatimPathogen = "+ genus Ilarvirus, Prune dwarf virus (PDV)",
      pathogen = "Prune dwarf virus",
      pathogenId = "id[Prune dwarf virus]",
      verbatimHost = expectedHosts.verbatimPeachHost,
      host = "Prunus persica var. nucipersica",
      hostId = "id[Prunus persica var. nucipersica]",
      hostPartName = "Rosette and decline",
      hostPartId = "id[Rosette and decline]",
      citation = expectedCitations.peachAndNectarine))
  }

  private def parsePeaches = {
    val doc: Document = parse("apsnet/PeachandNectarine.aspx")
    ParserApsnetStatic$.parse(doc)
  }

  "scrubbing name" should "remove whitespaces" in {
    val stringWithWeirdwhitespaces: String = "Mycoleptodiscus terrestris (Gerd.) Ostaz.           (syn. Leptodiscus terrestris Gerd.)"
    ParserApsnetStatic$.scrub(stringWithWeirdwhitespaces) should be("Mycoleptodiscus terrestris (Gerd.) Ostaz. (syn. Leptodiscus terrestris Gerd.)")
  }

  "Parsing disease index" should "result in a list of urls to species pages" in {
    val doc: Document = parse("apsnet/default.aspx")
    val links = ParserApsnetStatic$.parsePageIndex(doc)

    links should contain("http://www.apsnet.org/publications/commonnames/Pages/AfricanDaisy.aspx")
    links should contain("http://www.apsnet.org/publications/commonnames/Pages/PeachandNectarine.aspx")
  }

  "extract names" should "produce a list of extracted hostnames" in {
    val hostNames: String = expectedHosts.verbatimPeachHost
    ParserApsnetStatic$.extractHostNames(hostNames) should contain("Prunus persica")
    ParserApsnetStatic$.extractHostNames(hostNames) should contain("Prunus persica var. nucipersica")
    ParserApsnetStatic$.extractHostNames("Diseases of Almond (Prunus dulcis (Mill.) Webb)") should contain("Prunus dulcis")
  }

  "extract names" should "produce a list of extracted pathogens" in {
    val pathogenNames: String = "Genus Allexivirus; Garlic viruses A-D (GVA, GVB, GVC, GVD), Garlic virus X (GVX), Garlic mite-borne mosaic virus (GMbMV), Shallot virus X (ShVX)"
    ParserApsnetStatic$.extractPathogenNames(pathogenNames) should contain("Garlic virus X")
    ParserApsnetStatic$.extractPathogenNames(pathogenNames) should contain("Garlic virus A")
  }

  "extract names" should "produce a list of extracted pathogens without commas" in {
    val pathogenNames: String = "Genus Begomovirus: Sweet potato leaf curl Canary virus (SPLCCaV) Sweet potato leaf curl China virus (SPLCV-CN) Sweet potato leaf curl Georgia virus (SPLCGV) Sweet potato leaf curl Lanzarote virus (SPLCLaV) Sweet potato leaf curl South Carolina virus (SPLCSCV) Sweet potato leaf curl Spain virus (SPLCESV) Sweet potato leaf curl Uganda virus (SPLCUV) Sweet potato leaf curl virus (SPLCV)"
    ParserApsnetStatic$.extractPathogenNames(pathogenNames) should contain("Sweet potato leaf curl Canary virus")
    ParserApsnetStatic$.extractPathogenNames(pathogenNames) should contain("Sweet potato leaf curl Spain virus")
  }

  "extract names" should "produce a list of extracted pathogens with hyphens" in {
    val pathogenNames: String = "Genus Luteovirus; some virus–kerII, some virus–kerIII, some virus–MAV,some virus–PAS, some virus–PAV"
    ParserApsnetStatic$.extractPathogenNames(pathogenNames) should contain("some virus–kerIII")
    ParserApsnetStatic$.extractPathogenNames(pathogenNames) should contain("some virus–PAV")
  }

  "extract names" should "produce a list of extracted pathogens lower case" in {
    val pathogenNames: String = "genus Tobravirus, Tobacco rattle virus (TRV)"
    ParserApsnetStatic$.extractPathogenNames(pathogenNames) should contain("Tobacco rattle virus")
  }

  "extract names" should "produce a list of extracted pathogens no comma" in {
    val pathogenNames: String = "genus Potexvirus Wineberry latent virus (WLV)"
    ParserApsnetStatic$.extractPathogenNames(pathogenNames) should contain("Wineberry latent virus")
  }

  "extract names" should "and ignore stop words" in {
    val pathogenNames: String = "Other species include: P. scribneri Steiner"
    ParserApsnetStatic$.extractPathogenNames(pathogenNames) should contain("P. scribneri Steiner")
  }

  "extract names" should "and ignore +" in {
    val pathogenNames: String = "+ genus Ilarvirus, Prune dwarf virus (PDV)"
    ParserApsnetStatic$.extractPathogenNames(pathogenNames) should contain("Prune dwarf virus")
  }

  "extract names" should "and parse or" in {
    val pathogenNames: String = "Caused by either genus Nepovirus, Arabis mosaic virus (ArMV) or genus Nepovirus, Strawberry latent ringspot virus (SLRV)"
    ParserApsnetStatic$.extractPathogenNames(pathogenNames) should contain("Arabis mosaic virus")
    ParserApsnetStatic$.extractPathogenNames(pathogenNames) should contain("Strawberry latent ringspot virus")
  }

  "extract names" should "and parse candidate" in {
    ParserApsnetStatic$.extractPathogenNames("unassigned genus, Purple granadilla mosaic virus (PGMV)") should contain("Purple granadilla mosaic virus")
    val pathogenNames: String = "candidate Rhabdoviridae (unassigned genus), Passion fruit green spot virus (PGSV)"
    ParserApsnetStatic$.extractPathogenNames(pathogenNames) should contain("Passion fruit green spot virus")
  }

  "extract names" should "and parse synonyms" in {
    ParserApsnetStatic$.extractPathogenNames("(= Armillaria fuscipes Petch)") should contain("Armillaria fuscipes Petch")
    ParserApsnetStatic$.extractPathogenNames("(= Armillaria fuscipes Petch") should contain("Armillaria fuscipes Petch")
    ParserApsnetStatic$.extractPathogenNames("(anamorph: Zythia fragariae Laibach)") should contain("Zythia fragariae Laibach")
    ParserApsnetStatic$.extractPathogenNames("= Rhizoctonia microsclerotia J. Matz") should contain("Rhizoctonia microsclerotia J. Matz")
    ParserApsnetStatic$.extractPathogenNames("          (syn. C. piperiana Sacc. & Trott. ex Cummins)") should contain("C. piperiana Sacc. & Trott. ex Cummins")
    ParserApsnetStatic$.extractPathogenNames("          (syns. Pestalotia sydowiana Bres.; Pestalotiopsis rhododendri           Y. M. Zhang, Maharachch., & K. D. Hyde)") should contain("Pestalotia sydowiana Bres.")
    ParserApsnetStatic$.extractPathogenNames("          (syns. Pestalotia sydowiana Bres.; Pestalotiopsis rhododendri           Y. M. Zhang, Maharachch., & K. D. Hyde)") should contain("Pestalotiopsis rhododendri Y. M. Zhang")
    ParserApsnetStatic$.extractPathogenNames("‘Candidatus Phytoplasma asteris’") should contain("Candidatus Phytoplasma asteris")
  }

  "extract names" should "and ignore null mappings" in {
    ParserApsnetStatic$.extractPathogenNames("Slippers") should be(empty)
    ParserApsnetStatic$.extractPathogenNames("Mill.) Webb") should be(empty)
  }

  "expand prefixes" should "fill in genus names of previously mentioned species" in {
    ParserApsnetStatic$.expandPrefixes(List("Homo sapiens", "H. sapiens", "Ariopsis felis")) should be(List("Homo sapiens", "Homo sapiens", "Ariopsis felis"))
    ParserApsnetStatic$.expandPrefixes(List("Homo sapiens", "H sapiens", "Ariopsis felis")) should be(List("Homo sapiens", "Homo sapiens", "Ariopsis felis"))
    ParserApsnetStatic$.expandPrefixes(List("Lomo sapiens", "H sapiens", "Ariopsis felis")) should be(List("Lomo sapiens", "H sapiens", "Ariopsis felis"))
    ParserApsnetStatic$.expandPrefixes(List("Homo sapiens", "h sapiens", "Ariopsis felis")) should be(List("Homo sapiens", "Homo sapiens", "Ariopsis felis"))
  }

  "canonize" should "create canonical representation of a name" in {
    ParserApsnetStatic$.canonize("Pseudomonas cichorii (Swingle 1925) Stapp 1928") should be("Pseudomonas cichorii (Swingle 1925) Stapp 1928")
    ParserApsnetStatic$.canonize("sseudomonas cichorii (Swingle 1925) Stapp 1928") should be("")
    ParserApsnetStatic$.canonize("Fr.") should be("")
  }

  "map a name" should "map a name" in {
    val diseaseName = """Diseases of Sorghum (Sorghum bicolor (L.) Moench)"""
    ParserApsnetStatic$.mapNames(Seq(diseaseName)) should be(List("Sorghum bicolor"))
  }

}