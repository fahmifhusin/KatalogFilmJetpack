package com.brontocyber.jetpack3_fahmihusin.utils;

import com.brontocyber.jetpack3_fahmihusin.model.local.entity.Acara;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavMovies;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavTv;

import java.util.ArrayList;
import java.util.List;

public class FakeDummyAcara {
    public static final String IMAGE_URL ="https://image.tmdb.org/t/p/w342";

    //dummy movies
    public static ArrayList<Acara> generateMoviesDummy() {
        ArrayList<Acara> dataAcara = new ArrayList<>();
        dataAcara.add(new Acara(
                "475557",
                IMAGE_URL+"/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg",
                "Joker",
                "2019-10-02",
                "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure."));
        dataAcara.add(new Acara(
                "420818",
                IMAGE_URL+"/nRXO2SnOA75OsWhNhXstHB8ZmI3.jpg",
                "The Lion King",
                "2019-07-19",
                "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his."
        ));
        dataAcara.add(new Acara(
                "429617",
                IMAGE_URL+"/lcq8dVxeeOqHvvgcte707K0KVx5.jpg",
                "Spider-Man: Far from Home",
                "2019-07-02",
                "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent."
        ));
        dataAcara.add(new Acara(
                "384018",
                IMAGE_URL+"/keym7MPn1icW1wWfzMnW3HeuzWU.jpg",
                "Fast & Furious Presents: Hobbs & Shaw",
                "2019-08-02",
                "A spinoff of The Fate of the Furious, focusing on Johnson's US Diplomatic Security Agent Luke Hobbs forming an unlikely alliance with Statham's Deckard Shaw."
        ));
        dataAcara.add(new Acara(
                "474350",
                IMAGE_URL+"/zfE0R94v1E8cuKAerbskfD3VfUt.jpg",
                "It Chapter Two",
                "2019-09-06",
                "27 years after overcoming the malevolent supernatural entity Pennywise, the former members of the Losers' Club, who have grown up and moved away from Derry, are brought back together by a devastating phone call."
        ));
        dataAcara.add(new Acara(
                "301528",
                IMAGE_URL+"/w9kR8qbmQ01HwnvK4alvnQ2ca0L.jpg",
                "Toy Story 4",
                "2019-06-21",
                "Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called \\\"Forky\\\" to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy."
        ));
        dataAcara.add(new Acara(
                "920",
                IMAGE_URL+"/jpfkzbIXgKZqCZAkEkFH2VYF63s.jpg",
                "Cars",
                "2006-06-09",
                "Lightning McQueen, a hotshot rookie race car driven to succeed, discovers that life is about the journey, not the finish line, when he finds himself unexpectedly detoured in the sleepy Route 66 town of Radiator Springs. On route across the country to the big Piston Cup Championship in California to compete against two seasoned pros, McQueen gets to know the town's offbeat characters."
        ));
        dataAcara.add(new Acara(
                "449924",
                IMAGE_URL+"/mAWBfTDAmfpvQGMVFuzuVl49N1P.jpg",
                "Ip Man 4: The Finale",
                "2019-10-18",
                "Ip Man 4 is an upcoming Hong Kong biographical martial arts film directed by Wilson Yip and produced by Raymond Wong. It is the fourth in the Ip Man film series based on the life of the Wing Chun grandmaster of the same name and features Donnie Yen reprising the role. The film began production in April 2018 and ended in July the same year."
        ));
        dataAcara.add(new Acara(
                "420817",
                IMAGE_URL+"/3iYQTLGoy7QnjcUYRJy4YrAgGvp.jpg",
                "Aladdin",
                "2019-05-24",
                "A kindhearted street urchin named Aladdin embarks on a magical adventure after finding a lamp that releases a wisecracking genie while a power-hungry Grand Vizier vies for the same lamp that has the power to make their deepest wishes come true."
        ));
        dataAcara.add(new Acara(
                "458156",
                IMAGE_URL+"/ziEuG1essDuWuC5lpWUaw1uXY2O.jpg",
                "John Wick: Chapter 3 - Parabellum",
                "2019-05-17",
                "Super-assassin John Wick returns with a $14 million price tag on his head and an army of bounty-hunting killers on his trail. After killing a member of the shadowy international assassin’s guild, the High Table, John Wick is excommunicado, but the world’s most ruthless hit men and women await his every turn."
        ));
        dataAcara.add(new Acara(
                "320288",
                IMAGE_URL+"/cCTJPelKGLhALq3r51A9uMonxKj.jpg",
                "Dark Phoenix",
                "2019-06-07",
                "The X-Men face their most formidable and powerful foe when one of their own, Jean Grey, starts to spiral out of control. During a rescue mission in outer space, Jean is nearly killed when she's hit by a mysterious cosmic force. Once she returns home, this force not only makes her infinitely more powerful, but far more unstable. The X-Men must now band together to save her soul and battle aliens that want to use Grey's new abilities to rule the galaxy."
        ));
        dataAcara.add(new Acara(
                "429203",
                IMAGE_URL+"/a4BfxRK8dBgbQqbRxPs8kmLd8LG.jpg",
                "The Old Man & the Gun",
                "2018-09-28",
                "The true story of Forrest Tucker, from his audacious escape from San Quentin at the age of 70 to an unprecedented string of heists that confounded authorities and enchanted the public. Wrapped up in the pursuit are a detective, who becomes captivated with Forrest’s commitment to his craft, and a woman, who loves him in spite of his chosen profession."
        ));

        return dataAcara;
    }

    //dummy tv
    public static ArrayList<Acara> generateTvDummy() {
        ArrayList<Acara> dataTv = new ArrayList<>();
        dataTv.add(new Acara(
                "1412",
                IMAGE_URL+"/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
                "Arrow",
                "2012-10-10",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow."
        ));
        dataTv.add(new Acara(
                "62286",
                IMAGE_URL+"/lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg",
                "Fear the Walking Dead",
                "2015-08-23",
                "What did the world look like as it was transforming into the horrifying apocalypse depicted in \\\"The Walking Dead\\\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question."
        ));
        dataTv.add(new Acara(
                "60735,",
                IMAGE_URL+"/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "The Flash",
                "2014-10-07",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."
        ));
        dataTv.add(new Acara(
                "89247",
                IMAGE_URL+"/jnaimWkIVSD9IInmZPyLYarSvvc.jpg",
                "Batwoman",
                "2019-10-06",
                "Armed with a great passion for social justice and with a great facility to always say what she thinks, Kate Kane is known in the streets of Gotham as Batwoman, a lesbian highly trained to fight crime that resurfaces in the city. However, before becoming a savior, she must fight the demons that prevent her from being the symbol of the hope of a corrupt city."
        ));
        dataTv.add(new Acara(
                "2734",
                IMAGE_URL+"/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
                "Law & Order: Special Victims Unit",
                "1999-09-20",
                "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories."
        ));
        dataTv.add(new Acara(
                "1622",
                IMAGE_URL+"/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                "Supernatural",
                "2005-09-13",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. "
        ));
        dataTv.add(new Acara(
                "2190",
                IMAGE_URL+"/v9zc0cZpy5aPSfAy6Tgb6I1zWgV.jpg",
                "South Park",
                "1997-08-13",
                "Follows the misadventures of four irreverent grade-schoolers in the quiet, dysfunctional town of South Park, Colorado."
        ));
        dataTv.add(new Acara(
                "456",
                IMAGE_URL+"/yTZQkSsxUFJZJe67IenRM0AEklc.jpg",
                "The Simpsons",
                "1989-12-17",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general."
        ));
        dataTv.add(new Acara(
                "1434,",
                IMAGE_URL+"/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg",
                "Family Guy",
                "1999-01-31",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues."
        ));
        dataTv.add(new Acara(
                "1396",
                IMAGE_URL+"/1yeVJox3rjo2jBKrrihIMj7uoS9.jpg",
                "Breaking Bad",
                "2008-01-20",
                "When Walter White, a New Mexico chemistry teacher, is diagnosed with Stage III cancer and given a prognosis of only two years left to live. He becomes filled with a sense of fearlessness and an unrelenting desire to secure his family's financial future at any cost as he enters the dangerous world of drugs and crime."
        ));
        dataTv.add(new Acara(
                "65930",
                IMAGE_URL+"/47h1ReX6SSqwiTaz3kCC14f0vzt.jpg",
                "My Hero Academia",
                "2016-04-03",
                "In a world where eighty percent of the population has some kind of super-powered Quirk, Izuku was unlucky enough to be born completely normal. But that won’t stop him from enrolling in a prestigious hero academy. Now, he’ll get his first taste of brutal rivalry from other schools as he braves the cutthroat, no-holds-barred provisional license exam."
        )); dataTv.add(new Acara(
                "1416",
                IMAGE_URL+"/jnsvc7gCKocXnrTXF6p03cICTWb.jpg",
                "Grey's Anatomy",
                "2005-03-27",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital."
        ));
        return dataTv;
    }

    public static Acara generateDetailMovie(String id){
        ArrayList<Acara>detailMovie = generateMoviesDummy();
        for (int i = 0; i < detailMovie.size(); i++) {
            Acara entity = detailMovie.get(i);
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }

    public static Acara generateDetailTvShow(String id){
        ArrayList<Acara>detailTv = generateTvDummy();
        for (int i = 0; i < detailTv.size(); i++) {
            Acara entity = detailTv.get(i);
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }

    //dummy Fav
    public static List<FavMovies> loadFavMovie() {
        ArrayList<FavMovies> fav = new ArrayList<>();
        fav.add(new FavMovies(1,"IMAGE","JUDUL","RILIS"));
        return fav;
    }

    public static List<FavTv> loadFavTv() {
        ArrayList<FavTv> fav = new ArrayList<>();
        fav.add(new FavTv(1,"IMAGE","JUDUL","RILIS"));
        return fav;
    }

}
