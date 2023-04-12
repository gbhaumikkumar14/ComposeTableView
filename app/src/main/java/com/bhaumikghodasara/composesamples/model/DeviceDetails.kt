package com.bhaumikghodasara.composesamples.model

data class DeviceDetails(
    val deviceName: String?,
    val launchDate: String?,
    val networkTech: String?,
    val weight: Int?,
    val screenSize: Double?,
    val chipset: String?,
    val glassProtection: String?,
    val display: String?,
    val displayResolution: String?,
    val displayBrightness: Int?,
    val battery: String?,
    val frontCamera: String?,
    val backCamera: String?,
    val price: Double?,
    val imgUrl: String?,
    val rating: Int?,
    val reviews: Int?
)

fun getDevices(): List<DeviceDetails> {
    return listOf(
        DeviceDetails(
            deviceName = "OnePlus 11",
            launchDate = "2023, January 04",
            networkTech = "GSM / CDMA / HSPA / EVDO / LTE / 5G",
            weight = 205,
            screenSize = 6.7,
            chipset = "Qualcomm SM8550-AB Snapdragon 8 Gen 2 (4 nm)",
            glassProtection = "Glass front (Gorilla Glass Victus), glass back (Gorilla Glass 5), aluminum frame",
            display = "LTPO3 Fluid AMOLED, 1B colors, 120Hz, Dolby Vision, HDR10+, 500 nits (typ), 800 nits (HBM), 1300 nits (peak)",
            displayResolution = "1440 x 3216 pixels, 20:9 ratio (~525 ppi density)",
            displayBrightness = 1300,
            battery = "Li-Po 5000 mAh, non-removable",
            frontCamera = "16 MP, f/2.5, 25mm (wide), 1.0µm",
            backCamera = """50 MP, f/1.8, 24mm (wide), 1/1.56", 1.0µm, multi-directional PDAF, OIS
32 MP, f/2.0, 48mm (telephoto), 1/2.74", PDAF, 2x optical zoom
48 MP, f/2.2, 115˚, (ultrawide), 1/2.0", AF""",
            price = 792.68,
            imgUrl = "https://fdn2.gsmarena.com/vv/bigpic/oneplus-11.jpg",
            rating = 4,
            reviews = 159
        ),
        DeviceDetails(
            deviceName = "OnePlus 10 Pro",
            launchDate = "2022, January 11",
            networkTech = "GSM / CDMA / HSPA / EVDO / LTE / 5G",
            weight = 201,
            screenSize = 6.7,
            chipset = "Qualcomm SM8450 Snapdragon 8 Gen 1 (4 nm)",
            glassProtection = "Glass front (Gorilla Glass Victus), glass back (Gorilla Glass 5), aluminum frame",
            display = "LTPO2 Fluid AMOLED, 1B colors, 120Hz, HDR10+, 500 nits (typ), 800 nits (HBM), 1300 nits (peak)",
            displayResolution = "1440 x 3216 pixels, 20:9 ratio (~525 ppi density)",
            displayBrightness = 1300,
            battery = "Li-Po 5000 mAh, non-removable",
            frontCamera = "32 MP, f/2.2, (wide), 1/2.74\", 0.8µm",
            backCamera = """48 MP, f/1.8, 23mm (wide), 1/1.43", 1.12µm, multi-directional PDAF, Laser AF, OIS
8 MP, f/2.4, 77mm (telephoto), 1.0µm, PDAF, OIS, 3.3x optical zoom
50 MP, f/2.2, 14mm, 150˚ (ultrawide), 1/2.76", 0.64µm""",
            price = 731.70,
            imgUrl = "https://fdn2.gsmarena.com/vv/bigpic/oneplus-10-pro.jpg",
            rating = 3,
            reviews = 371
        ),
        DeviceDetails(
            deviceName = "OnePlus 10R",
            launchDate = "2022, April 28",
            networkTech = "GSM / HSPA / LTE / 5G",
            weight = 186,
            screenSize = 6.7,
            chipset = "Mediatek Dimensity 8100-Max (5 nm)",
            glassProtection = "Glass front (Gorilla Glass 5), plastic frame, plastic back",
            display = "Fluid AMOLED, 1B colors, 120Hz, HDR10+",
            displayResolution = "1080 x 2412 pixels, 20:9 ratio (~394 ppi density)",
            displayBrightness = null,
            battery = "Li-Po 5000 mAh, non-removable",
            frontCamera = "16 MP, f/2.4, 26mm (wide), 1/3.09\", 1.0µm",
            backCamera = """50 MP, f/1.8, 24mm (wide), 1/1.56", 1.0µm, PDAF, OIS
8 MP, f/2.2, 15mm, 120˚ (ultrawide), 1/4.0", 1.12µm
2 MP, f/2.4, (macro)""",
            price = 487.80,
            imgUrl = "https://fdn2.gsmarena.com/vv/bigpic/oneplus-10r.jpg",
            rating = 2,
            reviews = 420
        ),
        DeviceDetails(
            deviceName = "Apple iPhone 13",
            launchDate = "2021, September 14",
            networkTech = "GSM / CDMA / HSPA / EVDO / LTE / 5G",
            weight = 174,
            screenSize = 6.1,
            chipset = "Apple A15 Bionic (5 nm)",
            glassProtection = "Ceramic Shield glass",
            display = "Super Retina XDR OLED, HDR10, Dolby Vision, 800 nits (HBM), 1200 nits (peak)",
            displayResolution = "1170 x 2532 pixels, 19.5:9 ratio (~460 ppi density)",
            displayBrightness = 1200,
            battery = "Li-Ion 3240 mAh, non-removable (12.41 Wh)",
            frontCamera = "12 MP, f/2.2, 23mm (wide), 1/3.6\"",
            backCamera = """12 MP, f/1.6, 26mm (wide), 1.7µm, dual pixel PDAF, sensor-shift OIS
12 MP, f/2.4, 120˚, 13mm (ultrawide)""",
            price = 902.43,
            imgUrl = "https://fdn2.gsmarena.com/vv/bigpic/apple-iphone-13.jpg",
            rating = 5,
            reviews = 223
        ),
        DeviceDetails(
            deviceName = "Apple iPhone 14",
            launchDate = "2022, September 07",
            networkTech = "GSM / CDMA / HSPA / EVDO / LTE / 5G",
            weight = 172,
            screenSize = 6.1,
            chipset = "Apple A15 Bionic (5 nm)",
            glassProtection = "Ceramic Shield glass",
            display = "Super Retina XDR OLED, HDR10, Dolby Vision, 800 nits (HBM), 1200 nits (peak)",
            displayResolution = "1170 x 2532 pixels, 19.5:9 ratio (~460 ppi density)",
            displayBrightness = 1200,
            battery = "Li-Ion 3279 mAh, non-removable (12.68 Wh)",
            frontCamera = "12 MP, f/1.9, 23mm (wide), 1/3.6\", PDAF",
            backCamera = """12 MP, f/1.5, 26mm (wide), 1/1.7", 1.9µm, dual pixel PDAF, sensor-shift OIS
12 MP, f/2.4, 13mm, 120˚ (ultrawide)""",
            price = 1297.56,
            imgUrl = "https://fdn2.gsmarena.com/vv/bigpic/apple-iphone-14.jpg",
            rating = 0,
            reviews = 994
        )
    )
}

fun getValueFromAttributeName(deviceDetails: DeviceDetails, attr: String): String? {
    return when (attr) {
        "deviceName" -> deviceDetails.deviceName
        "launchDate" -> deviceDetails.launchDate
        "networkTech" -> deviceDetails.networkTech
        "weight" -> "${deviceDetails.weight} g"
        "screenSize" -> "${deviceDetails.screenSize} inches"
        "chipset" -> deviceDetails.chipset
        "glassProtection" -> deviceDetails.glassProtection
        "display" -> deviceDetails.display
        "displayResolution" -> deviceDetails.displayResolution
        "displayBrightness" -> {
            if (deviceDetails.displayBrightness != null)
                "${deviceDetails.displayBrightness} nits"
            else
                "-"
        }
        "battery" -> deviceDetails.battery
        "frontCamera" -> deviceDetails.frontCamera
        "backCamera" -> deviceDetails.backCamera
        else -> ""
    }
}

fun getAttrsList(): List<String> = listOf(
    "rating", "launchDate", "networkTech", "weight", "screenSize", "chipset",
    "glassProtection", "display", "displayResolution", "displayBrightness", "battery",
    "frontCamera", "backCamera"
)

fun getAttrDisplayNameFromAttr(attr: String): String {
    return when (attr) {
        "launchDate" -> "Launch Date"
        "networkTech" -> "Network"
        "weight" -> "Weight"
        "screenSize" -> "Screen size"
        "chipset" -> "CPU"
        "glassProtection" -> "Glass Protection"
        "display" -> "Display"
        "displayResolution" -> "Resolution"
        "displayBrightness" -> "Brightness"
        "battery" -> "Battery"
        "frontCamera" -> "Selfie Camera"
        "backCamera" -> "Main Camera"
        "rating" -> "Rating"
        else -> ""
    }
}

