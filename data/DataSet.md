
## The dataset
Data from https://archive.ics.uci.edu/ml/datasets/Zoo

This dataset consists of 101 animals from a zoo. There are 16 variables with various traits to describe the animals. 
The 7 Class Types are: 
|1|Mammal|
|2|Bird|
|3|Reptile|
|4|Fish|
|5|Amphibian|
|6|Bug|
|7|Invertebrate|


* animal name:      Unique for each instance
* hair		Boolean
* feathers		Boolean
* eggs		Boolean
* milk		Boolean
* airborne		Boolean
* aquatic		Boolean
* predator		Boolean
* toothed		Boolean
* backbone		Boolean
* breathes		Boolean
* venomous		Boolean
* fins		Boolean
* legs		Numeric (set of values: {0,2,4,5,6,8})
* tail		Boolean
* domestic		Boolean
* catsize		Boolean
* type		Numeric (integer values in range [1,7])

      Class# Set of animals:
      ====== ===============================================================
           1 (41) aardvark, antelope, bear, boar, buffalo, calf,
                  cavy, cheetah, deer, dolphin, elephant,
                  fruitbat, giraffe, girl, goat, gorilla, hamster,
                  hare, leopard, lion, lynx, mink, mole, mongoose,
                  opossum, oryx, platypus, polecat, pony,
                  porpoise, puma, pussycat, raccoon, reindeer,
                  seal, sealion, squirrel, vampire, vole, wallaby,wolf
           2 (20) chicken, crow, dove, duck, flamingo, gull, hawk,
                  kiwi, lark, ostrich, parakeet, penguin, pheasant,
                  rhea, skimmer, skua, sparrow, swan, vulture, wren
           3 (5)  pitviper, seasnake, slowworm, tortoise, tuatara 
           4 (13) bass, carp, catfish, chub, dogfish, haddock,
                  herring, pike, piranha, seahorse, sole, stingray, tuna
           5 (4)  frog, frog, newt, toad 
           6 (8)  flea, gnat, honeybee, housefly, ladybird, moth, termite, wasp
           7 (10) clam, crab, crayfish, lobster, octopus,
                  scorpion, seawasp, slug, starfish, worm

## Install MySQL on a Mac

Ensure you have [Homebrew](https://brew.sh/) installed.

1. `brew install mysql`
2. `mysql.server start`
3. `mysqladmin -u root password`

   Enter a root password of your choosing for the MySQL server.

To initialize your database:

`mysql -uroot -p < create.sql`

`mysql -uroot -p -D college_management < students.sql`
