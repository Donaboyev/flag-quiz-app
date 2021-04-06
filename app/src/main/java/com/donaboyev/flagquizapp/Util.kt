package com.donaboyev.flagquizapp

import android.content.Context
import java.util.*
import kotlin.collections.ArrayList

object Util {

    fun getRandomQuestions(context: Context): List<Question> {
        val questions = ArrayList<Question>()

        repeat(10) {
            val answer = getRandomCorrectAnswer()
            val name = getRandomName()
            when (answer) {
                1 -> questions.add(
                    Question(
                        getImage(context, name),
                        getName(context, name),
                        getRandomNameWithoutCorrect(context, name),
                        getRandomNameWithoutCorrect(context, name),
                        getRandomNameWithoutCorrect(context, name),
                        1
                    )
                )
                2 -> questions.add(
                    Question(
                        getImage(context, name),
                        getRandomNameWithoutCorrect(context, name),
                        getName(context, name),
                        getRandomNameWithoutCorrect(context, name),
                        getRandomNameWithoutCorrect(context, name),
                        2
                    )
                )
                3 -> questions.add(
                    Question(
                        getImage(context, name),
                        getRandomNameWithoutCorrect(context, name),
                        getRandomNameWithoutCorrect(context, name),
                        getName(context, name),
                        getRandomNameWithoutCorrect(context, name),
                        3
                    )
                )
                4 -> questions.add(
                    Question(
                        getImage(context, name),
                        getRandomNameWithoutCorrect(context, name),
                        getRandomNameWithoutCorrect(context, name),
                        getRandomNameWithoutCorrect(context, name),
                        getName(context, name),
                        4
                    )
                )
            }

        }
        return questions
    }

    private fun getRandomNameWithoutCorrect(context: Context, name: String): String {
        var randomName = getRandomName()
        while (randomName == name) {
            randomName = getRandomName()
        }
        return getName(context, randomName)
    }

    private fun getRandomCorrectAnswer() = arrayOf(1, 2, 3, 4).random()

    private fun getImage(context: Context, name: String) =
        context.resources.getIdentifier(
            name.toLowerCase(Locale.ROOT),
            "drawable",
            context.packageName
        )

    private fun getName(context: Context, name: String) =
        context.getString(
            context.resources.getIdentifier(
                name,
                "string",
                context.packageName
            )
        )


    private fun getRandomName() = arrayOf(
        "AD",
        "AE",
        "AF",
        "AG",
        "AI",
        "AL",
        "AM",
        "AO",
        "AQ",
        "AR",
        "AS",
        "AT",
        "AU",
        "AW",
        "AX",
        "AZ",
        "BA",
        "BB",
        "BD",
        "BE",
        "BF",
        "BG",
        "BH",
        "BI",
        "BJ",
        "BL",
        "BM",
        "BN",
        "BO",
        "BQ",
        "BR",
        "BS",
        "BT",
        "BV",
        "BW",
        "BY",
        "BZ",
        "CA",
        "CC",
        "CD",
        "CF",
        "CG",
        "CH",
        "CI",
        "CK",
        "CL",
        "CM",
        "CN",
        "CO",
        "CR",
        "CU",
        "CV",
        "CW",
        "CX",
        "CY",
        "CZ",
        "DE",
        "DJ",
        "DK",
        "DM",
        "DO",
        "DZ",
        "EC",
        "EE",
        "EG",
        "EH",
        "ER",
        "ES",
        "ET",
        "EU",
        "FI",
        "FJ",
        "FK",
        "FM",
        "FO",
        "FR",
        "GA",
        "GB_ENG",
        "GB_NIR",
        "GB_SCT",
        "GB_WLS",
        "GB",
        "GD",
        "GE",
        "GF",
        "GG",
        "GH",
        "GI",
        "GL",
        "GM",
        "GN",
        "GP",
        "GQ",
        "GR",
        "GS",
        "GT",
        "GU",
        "GW",
        "GY",
        "HK",
        "HM",
        "HN",
        "HR",
        "HT",
        "HU",
        "ID",
        "IE",
        "IL",
        "IM",
        "IN",
        "IO",
        "IQ",
        "IR",
        "IS",
        "IT",
        "JE",
        "JM",
        "JO",
        "JP",
        "KE",
        "KG",
        "KH",
        "KI",
        "KM",
        "KN",
        "KP",
        "KR",
        "KW",
        "KY",
        "KZ",
        "LA",
        "LB",
        "LC",
        "LI",
        "LK",
        "LR",
        "LS",
        "LT",
        "LU",
        "LV",
        "LY",
        "MA",
        "MC",
        "MD",
        "ME",
        "MF",
        "MG",
        "MH",
        "MK",
        "ML",
        "MM",
        "MN",
        "MO",
        "MP",
        "MQ",
        "MR",
        "MS",
        "MT",
        "MU",
        "MV",
        "MW",
        "MX",
        "MY",
        "MZ",
        "NA",
        "NC",
        "NE",
        "NF",
        "NG",
        "NI",
        "NL",
        "NO",
        "NP",
        "NR",
        "NU",
        "NZ",
        "OM",
        "PA",
        "PE",
        "PF",
        "PG",
        "PH",
        "PK",
        "PL",
        "PM",
        "PN",
        "PR",
        "PS",
        "PT",
        "PW",
        "PY",
        "QA",
        "RE",
        "RO",
        "RS",
        "RU",
        "RW",
        "SA",
        "SB",
        "SC",
        "SD",
        "SE",
        "SG",
        "SH",
        "SI",
        "SJ",
        "SK",
        "SL",
        "SM",
        "SN",
        "SO",
        "SR",
        "SS",
        "ST",
        "SV",
        "SX",
        "SY",
        "SZ",
        "TC",
        "TD",
        "TF",
        "TG",
        "TH",
        "TJ",
        "TK",
        "TL",
        "TM",
        "TN",
        "TO",
        "TR",
        "TT",
        "TV",
        "TW",
        "TZ",
        "UA",
        "UG",
        "UM",
        "US",
        "UY",
        "UZ",
        "VA",
        "VC",
        "VE",
        "VG",
        "VI",
        "VN",
        "VU",
        "WF",
        "WS",
        "XK",
        "YE",
        "YT",
        "ZA",
        "ZM",
        "ZW"
    ).random()

}