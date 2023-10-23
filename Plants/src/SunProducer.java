interface SunProducer {
    int produce_sun();
}

interface PlantUpgrade {
    int concurrentSunCost();
}

// add more interfaces here

interface Attacker {
    int attack();
    RangeType rangeType();
}

interface InstantKiller {
    KillType killType();
}

interface Upgradable {
    Plant upgrade();
}

enum RangeType {
    SINGLE_LINE, AOE, LIMITED_RANGE, FREE_RANGE
}

enum KillType {
    INSTANTLY, ON_CONTACT
}