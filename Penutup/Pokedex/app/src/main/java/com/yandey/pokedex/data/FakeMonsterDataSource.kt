package com.yandey.pokedex.data

import com.yandey.pokedex.data.models.Monster
import com.yandey.pokedex.data.models.Owner

@Suppress("unused")
object FakeMonsterDataSource {

    val dummyMonster = listOf(
        Monster(
            1,
            "Pikachu",
            "Mouse",
            listOf("Electric"),
            "Male",
            "Pikachu is a short, chubby rodent Pokémon. It is covered in yellow fur with two horizontal brown stripes on its back. It has a small mouth, long, pointed ears with black tips, and brown eyes. Each cheek is a red circle that contains a pouch for electricity storage. It has short forearms with five fingers on each paw, and its feet each have three toes. At the base of its lightning bolt-shaped tail is a patch of brown fur. A female will have a V-shaped notch at the end of its tail, which looks like the top of a heart. It is classified as a quadruped, but it has been known to stand and walk on its hind legs.",
            "1' 04\"",
            "Ground",
            "13.2 lbs",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png",
            Owner(
                1,
                "Ash Ketchum",
                "Pokemon Trainer",
                "https://archives.bulbagarden.net/media/upload/c/cd/Ash_JN.png"
            )
        ),
        Monster(
            2,
            "Psyduck",
            "Duck",
            listOf("Water"),
            "Female",
            "Psyduck is a yellow Pokémon resembling a duck or a bipedal platypus. On top of its head are three thick strands of black hair, and it has a wide, flat cream-colored beak. Psyduck's eyes seem vacant and have tiny pupils. Its legs and tail are stubby, and it has cream-colored webbed feet. There are three claws on each of its hands.",
            "2' 07\"",
            "Grass",
            "43.2 lbs",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/054.png",
            Owner(
                2,
                "Misty",
                "Gym Leader",
                "https://archives.bulbagarden.net/media/upload/f/f6/Lets_Go_Pikachu_Eevee_Misty.png"
            )
        ),
        Monster(
            3,
            "Butterfree",
            "Butterfly",
            listOf("Bug", "Flying"),
            "Female",
            "Butterfree is a lepidopteran insect Pokémon which resembles a vaguely anthropomorphic butterfly with a purple body. Unlike true insects, it only has two body segments and four light blue legs. The upper pair of its legs resemble small, three-fingered hands, while the lower pair resembles long, digit-less feet. Butterfree has two black antennae, a light blue snout with two fangs underneath, and large, red compound eyes. Its two pairs of wings are white with black venation. Two oval scales on a female Butterfree's lower wings are black, but they are white on a male.",
            "3' 07\"",
            "Fire",
            "70.5 lbs",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/012.png",
            Owner(
                3,
                "May",
                "Pokemon Coordinator",
                "https://archives.bulbagarden.net/media/upload/a/a0/Omega_Ruby_Alpha_Sapphire_May.png"
            )
        ),
        Monster(
            4,
            "Piplup",
            "Penguin",
            listOf("Water"),
            "Female",
            "Piplup is a light-blue, penguin-like Pokémon, which is covered in thick down to insulate against the cold. It has a dark blue head with a primarily white face and a short, yellow beak. The dark blue feathers on its head extend down its back and around its neck, which causes it to appear to be wearing a cape. There are two white ovals on its chest and a small, light-blue marking resembles a crown above its beak. It has flipper-like arms and yellow feet with three toes each.",
            "1' 04\"",
            "Grass",
            "11.5 lbs",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/393.png",
            Owner(
                4,
                "Dawn",
                "Pokemon Coordinator",
                "https://archives.bulbagarden.net/media/upload/3/34/Dawn_JN.png"
            )
        ),
        Monster(
            5,
            "Spiritomb",
            "Forbidden",
            listOf("Ghost", "Dark"),
            "Male",
            "Spiritomb is a ghostly purple Pokémon attached to a stone. Although lacking a physical body, Spiritomb projects its appearance out of a small rock called the Odd Keystone. The rock is trapezoidal in shape and has two small dots. There is a crack running down the middle, splitting in two near the bottom. The crack in combination with the two dots appears to form a frowning face. Spiritomb's projected appearance is an ethereal composition of swirling purple fog. Its face is set in the middle of the fog and contains green, crescent eyes that are connected to its jagged mouth. Its pupils are composed of a spiral and it is sometimes only seen with one. Swirling around its face are green orbs with yellow centers.",
            "3' 03\"",
            "Fairy",
            "238.1 lbs",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/442.png",
            Owner(
                5,
                "Cynthia",
                "Pokemon Trainer",
                "https://archives.bulbagarden.net/media/upload/c/c3/Brilliant_Diamond_Shining_Pearl_Cynthia.png"
            )
        ),
        Monster(
            6,
            "Arbok",
            "Cobra",
            listOf("Poison"),
            "Male",
            "Arbok is a serpentine Pokémon that resembles a cobra. It has narrow eyes and several sharp teeth. Just below its head is a large hood with a face-like pattern. This pattern has over 20 possible variations. The pattern typically has two red and yellow eyespots outlined in black, a wide black streak resembling an upturned mouth, and a black V-shaped stripe above the eyespots.",
            "11' 06\"",
            "Psychic",
            "143.3 lbs",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/024.png",
            Owner(
                6,
                "Jessie",
                "Agent",
                "https://archives.bulbagarden.net/media/upload/0/0d/Jessie_JN.png"
            )
        ),
        Monster(
            7,
            "Slugma",
            "Lava",
            listOf("Fire"),
            "Male",
            "Slugma is a limbless gastropod molusk Pokémon composed of magma. Its body is bright red, fading to a duller red along its extremities. It has large, round, yellow eyes with small pupils. Slugma's head is ovoid with flame-like extensions spreading upward from its eyes and round, stable drops of magma dangling from its upper jaw. Its lower body is irregular in shape, and occasionally emits bubbles.",
            "2' 04\"",
            "Water",
            "77.2 lbs",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/218.png",
            Owner(
                7,
                "Flannery",
                "Gym Leader",
                "https://archives.bulbagarden.net/media/upload/b/ba/Omega_Ruby_Alpha_Sapphire_Flannery.png"
            )
        ),
        Monster(
            8,
            "Growlithe",
            "Puppy",
            listOf("Fire"),
            "Male",
            "Growlithe is a quadrupedal canine Pokémon. It has orange fur with black stripes along its back and legs. The fur on its muzzle, chest, belly, and tail is beige, as is an additional tuft of fur on top of its head. Growlithe's coat is noticeably longer on its chest and tail. It has gray eyes, a black nose, and large, round and triangular ears with beige interiors. Its forepaws have two visible claws, while its hind paws have three toes each. Each paw has a brown pad.",
            "2' 04\"",
            "Water",
            "41.9 lbs",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/058.png",
            Owner(
                8,
                "James",
                "Agent",
                "https://archives.bulbagarden.net/media/upload/1/19/James_JN.png"
            )
        ),
        Monster(
            9,
            "Alakazam",
            "Psi",
            listOf("Psychic"),
            "Male",
            "Alakazam is a slightly humanoid Pokémon with a large mustache. A female Alakazam has a significantly shorter mustache than a male. It has a long, thin snout, narrow eyes, ear-like spikes extending from the top of its head, and an additional spike protruding from each cheek. Covering its yellow, skeletal body are brown armor-like sections over its chest, shoulders, forearms, and knees. There are three toes on each foot, each of which has a white claw. Two of the toes face forward, while one faces backwards. It wields a silver spoon in each hand, which act as amplifiers for its psychic abilities. The spoons are created using its psychic powers and it may give one to someone it trusts.",
            "4' 11\"",
            "Ghost",
            "105.8 lbs",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/065.png",
            Owner(
                9,
                "Sabrina",
                "Gym Leader",
                "https://archives.bulbagarden.net/media/upload/7/78/Lets_Go_Pikachu_Eevee_Sabrina.png"
            )
        ),
        Monster(
            10,
            "Fennekin",
            "Fox",
            listOf("Fire"),
            "Female",
            "Fennekin is a small, quadrupedal fox-like Pokémon. It is covered in pale yellow fur that is longer on its haunches. It has a white muzzle with longer fur on its cheeks, large, dark orange eyes, and a pointed, black nose. When its mouth is open, two pointed teeth can be seen in its upper jaw. Tufts of dark orange fur cover the interior of its large ears. Fennekin also has small paws with no visible toes and slim legs. Its tail is fluffy with a dark orange tip.",
            "1' 04\"",
            "Water",
            "20.7 lbs",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/653.png",
            Owner(
                10,
                "Serena",
                "Pokemon Former",
                "https://archives.bulbagarden.net/media/upload/d/d5/Serena_XY2.png"
            )
        ),
        Monster(
            11,
            "Emolga",
            "Sky Squirrel",
            listOf("Electric", "Flying"),
            "Male",
            "Emolga is a white, rodent-like Pokémon resembling a flying squirrel. It has black eyes, a tiny nose, and yellow electric sacs on its cheeks. Its ears, positioned at the top of its head, are rounded in shape and black in coloration, with yellow and white sections in the inside. It sports a vaguely hood-like patterning of black around its head, with a spiky extension of the pattern above its face. It has yellow winglike membrane flaps connected to its three-fingered arms. Its feet are white and fairly small and its black tail is in a jagged shape.",
            "1' 04\"",
            "Ice",
            "11.0 lbs",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/587.png",
            Owner(
                11,
                "Elesa",
                "Gym Leader",
                "https://archives.bulbagarden.net/media/upload/4/40/Black_2_White_2_Elesa.png"
            )
        ),
        Monster(
            12,
            "Clefairy",
            "Fairy",
            listOf("Psychic"),
            "Female",
            "Clefairy is a bipedal, pink Pokémon with a chubby, vaguely star-shaped body. A small, pointed tooth protrudes from the upper left corner of its mouth. It has wrinkles beside its black, oval eyes, a single dark pink oval marking on each cheek, and large, pointed ears with brown tips. A tuft of fur curls over its forehead, much like its large, upward-curling tail. Each stocky arm has two small claws and a thumb on each hand and both feet have a single toenail. There is a pair of tiny, butterfly-shaped wings on its back. Though incapable of flight, Clefairy's wings can store moonlight and allow it to float.",
            "2' 00\"",
            "Steel",
            "16.5 lbs",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/035.png",
            Owner(
                12,
                "Whitney",
                "Leader of the Goldenrod Gym",
                "https://archives.bulbagarden.net/media/upload/e/e1/HeartGold_SoulSilver_Whitney.png"
            )
        ),
        Monster(
            13,
            "Geodude",
            "Rock",
            listOf("Rock", "Ground"),
            "Male",
            "Geodude is a brownish-gray boulder Pokémon. It has bulging, rocky eyebrows, trapezoidal, brown eyes, and a wide mouth. Its arms are muscular with five-fingered hands. Geodude uses its arms to climb steadily up steep mountain paths. As a result of their physical appearance, Rhyperior sometimes mistake this Pokémon for actual boulders and fire them through their hands.",
            "1' 04\"",
            "Steel",
            "44.1 lbs",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/074.png",
            Owner(
                13,
                "Brock",
                "Gym Leader",
                "https://archives.bulbagarden.net/media/upload/a/a6/Lets_Go_Pikachu_Eevee_Brock.png"
            )
        ),
        Monster(
            14,
            "Bulbasaur",
            "Seed",
            listOf("Grass", "Poison"),
            "Male",
            "Bulbasaur is a small, quadrupedal amphibian Pokémon that has blue-green skin with darker patches. It has red eyes with white pupils, pointed, ear-like structures on top of its head, and a short, blunt snout with a wide mouth. A pair of small, pointed teeth are visible in the upper jaw when its mouth is open. Each of its thick legs ends with three sharp claws. On Bulbasaur's back is a green plant bulb, which is grown from a seed planted there at birth. The bulb also conceals two slender, tentacle-like vines and provides it with energy through photosynthesis as well as from the nutrient-rich seeds contained within.",
            "2' 04\"",
            "Fire",
            "15.2 lbs",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
            Owner(
                14,
                "Jenny",
                "Officer",
                "https://archives.bulbagarden.net/media/upload/b/bb/Officer_Jenny_JN.png"
            )
        ),
        Monster(
            15,
            "Swoobat",
            "Courting",
            listOf("Psychic", "Flying"),
            "Male",
            "Swoobat is a blue, bat-like Pokémon. It has fused, pointed ears with striated, lighter-colored insides and a pink, heart-shaped snout with a single nostril. Two wide, rounded teeth are visible in its lower jaw. A mane of shaggy, light blue fur surrounds its neck. Its black wings have a claw at the joint, and its small black feet have three toes each. It has a bare, pink tail that is twisted with two short prongs at the tip.",
            "2' 11\"",
            "Ghost",
            "23.1 lbs",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/528.png",
            Owner(
                15,
                "Skyla",
                "Gym Leader",
                "https://archives.bulbagarden.net/media/upload/8/80/Black_White_Skyla.png"
            )
        )
    )
}