package edu.um.coffe

import android.app.Application
import edu.um.coffe.data.*
import edu.um.coffe.model.Model
import kotlinx.coroutines.runBlocking

class MainApplication :Application() {
    val database by lazy { CoffeeDatabase.getInstance(this) }

    companion object {
        lateinit var repository : Model
    }

    override fun onCreate() {
        super.onCreate()
        repository =  Model(database.coffeDao)
        runBlocking {
            repository.insertCafe(Cafe(
                        "1", "Cafe Vianna", 4.1F, Localizacao("Praça da República, 4710-251 Braga",  41.55142318255202, -8.423442530782571617759),
                        Contacto("+351253262336"), Horario(9,0,2,0),"cafevianna")
                    )

            repository.insertCafe(Cafe(
                "2", "Nata Lisboa - Braga", 4.4F, Localizacao("Largo de São Francisco 13 a 20, 4700-307 Braga",  41.55197878206903, -8.423875217288133),
                Contacto("+351253257154"), Horario(8,30,19,30),"natalisboa")
            )
            repository.insertCafe(Cafe(
                "3", "Leitaria da Quinta do Paço", 4.5F, Localizacao("Largo de São Francisco 37, 4700-228 Braga",  41.55169589528217, -8.423913301947332),
                Contacto("+351253727092"), Horario(9,0,19,0),"leitariadaquintadopaco"))
            repository.insertCafe(Cafe(
                "4", "Pastelaria Bella Braga", 4.7F, Localizacao(" R. dos Chãos 29, 4710-230 Braga",  41.55250862378731, -8.423624586606595),
                Contacto("+351253178012"), Horario(7,0,20,0),"bellabraga"))
            repository.insertCafe(Cafe(
                "5", "Montalegrense", 4.3F, Localizacao("Praça Alexandre Herculano 1, 4700-387 Braga",  41.553749279252415, -8.423796286606533),
                Contacto("+351253676306"), Horario(7,30,23,0),"montalegrense"))
            repository.insertCafe(Cafe(
                "6", "Casa das Natas", 4.4F, Localizacao("4, Praça da Galiza 8",  41.55468405061853, -8.425791803793611),
                Contacto("+351253681353"), Horario(7,30,20,0),"casadasnatas"))
            repository.insertCafe(Cafe(
                "7", "Berber Shisha Café Marroquino", 4.4F, Localizacao("Av. Gen. Norton de Matos 118, 4700-387 Braga",  41.55608630771275, -8.424815830782451),
                Contacto("+351253215462"), Horario(20,0,2,0),"berber"))
            repository.insertCafe(Cafe(
                "8", "Braga Parque, Pastelaria & Pão Quente", 4.2F, Localizacao("R. Conselheiro Januário 43, 4700-361 Braga",  41.55644053718427, -8.420937073112071),
                Contacto("+351253275226"), Horario(7,0,20,0),"bragaparque"))
            repository.insertCafe(Cafe(
                "9", "Doçaria de S. Vicente", 4.5F, Localizacao("R. Conselheiro Januário 151, 4700-373 Braga",  41.557030320978704, -8.419296815441673),
                Contacto("+351253068387"), Horario(7,30,19,30),"vicente"))
            repository.insertCafe(Cafe(
                "10", "Pastelaria Dom Diogo", 4.2F, Localizacao("R. Conselheiro Bento Miguel 68, 4710-300 Braga",  41.55807466389588, -8.415752328936087),
                Contacto("+351253186393"), Horario(8,0,21,0),"pastelariadomdiogo"))
            repository.insertCafe(Cafe(
                "11", "Pastelaria Veneza", 4.3F, Localizacao("Jardim da Avenida Central, 4710-229 Braga",  41.55106067925277, -8.422124359617762),
                Contacto("+351253263217"), Horario(8,0,19,30),"pastelariaveneza"))
            repository.insertCafe(Cafe(
                "12", "Celeste Grupo", 3.9F, Localizacao("Av. da Liberdade 805, 4700-328 Braga",  41.55088996657379, -8.422951944277003),
                Contacto("+351253520460"), Horario(8,0,21,0),"celestegrupo"))
            repository.insertCafe(Cafe(
                "13", "A Brasileira", 4.3F, Localizacao("Largo do Barão de São Martinho 17, 4700-328 Braga",  41.550827450139984, -8.42353034427703),
                Contacto("+351253262104"), Horario(8,0,22,30),"abrasileira"))
            repository.insertCafe(Cafe(
                "14", "Sabores Gelados", 4.0F, Localizacao("Rua Do Souto Nº141/ E Largo Barão S.Martinho, 4700-306 Braga",  41.5508984956784, -8.424207632628873),
                Contacto("+351253067144"), Horario(11,0,0,0),"saboresgelados"))
            repository.insertCafe(Cafe(
                "15", "Nut Braga", 4.2F, Localizacao("R. do Souto 135, 4705-329 Braga",  41.55083953747819, -8.424243144277),
                Contacto("+351253263085"), Horario(13,0,0,0),"nutbraga"))
            repository.insertCafe(Cafe(
                "16", "Pastelaria Lusitana", 4.1F, Localizacao("R. Dr. Justino Cruz 127, 4700-317 Braga",  41.55120845018721, -8.425568844276954),
                Contacto("+351253614791"), Horario(8,0,20,0),"pastelarialusitana"))
            repository.insertCafe(Cafe(
                "17", "Pastelaría Bom Jesus", 3.4F, Localizacao(" R. Dom Diogo de Sousa 522, 4700-424 Braga",  41.550526220953365, -8.426926215441833),
                Contacto("+351253273711"), Horario(7,0,19,0),"pastelariabomjesus"))
            repository.insertCafe(Cafe(
                "18", "A Loja Dos Pastéis De Chaves", 3.9F, Localizacao("R. Dom Diogo de Sousa 125, 4700-319 Braga",  41.55051969586684, -8.427375015441806),
                Contacto("+351253132067"), Horario(9,0,2,0),"alojadospasteisdechaves"))
            repository.insertCafe(Cafe(
                "19", "APE Coffee - Braga", 4.7F, Localizacao("R. Dom Frei Caetano Brandão 61, 4700-031 Braga",  41.55046590841129, -8.42848218660659),
                Contacto("+351925954971"), Horario(14,0,0,0),"apecoffeebraga"))
            repository.insertCafe(Cafe(
                "20", "Tibias De Braga", 4.5F, Localizacao(" Av. São Miguel O Anjo 5, 4700-210 Braga",  41.5502780208917, -8.429602932628901),
                Contacto("+351253035625"), Horario(7,30,19,0),"tibiasdebraga"))
            repository.insertCafe(Cafe(
                "21", "Café Snack Bar Porta Nova", 4.5F, Localizacao("R. Dom Diogo de Sousa 32 40, 4700-422 Braga",  41.55027217925293, -8.42856720194739),
                Contacto("+351969808554"), Horario(8,0,23,0),"cafesnackbarportanova"))
            repository.insertCafe(Cafe(
                "22", "Pátio da Sé", 4.4F, Localizacao("R. Dom Paio Mendes n.63, 4700-424 Braga",  41.54988342079363, -8.428042857771446),
                Contacto("+351963135911"), Horario(14,0,4,0),"patiodase"))
            repository.insertCafe(Cafe(
                "23", "Estúdio 22", 4.2F, Localizacao("R. Dom Paio Mendes 22, 4700-424 Braga",  41.54967267925268, -8.427995201947422),
                Contacto("+351253053751"), Horario(12,0,2,0),"estudio22"))
            repository.insertCafe(Cafe(
                "24", "Rossio Bar", 4.4F, Localizacao("R. Dom Paio Mendes 81, 4700-424 Braga",  41.54994149615402, -8.42777767311221),
                Contacto("+351919092242"), Horario(15,0,2,0),"rossiobar"))
            repository.insertCafe(Cafe(
                "25", "Frigideiras da Sé", 4.0F, Localizacao("R. Dom Afonso Henriques 57, 4700-321 Braga",  41.54919200856974, -8.426944817288181),
                Contacto("+351253220266"), Horario(7,30,20,0),"frigideirasdasa"))
            repository.insertCafe(Cafe(
                "26", "Barhaus", 4.3F, Localizacao("R. Dom Gonçalo Pereira 58, 4700-426 Braga",  41.54883374354117, -8.426878132628957),
                Contacto("+351910565943"), Horario(18,0,4,0),"barhausbraga"))
            repository.insertCafe(Cafe(
                "27", "Pelle", 4.6F, Localizacao("R. de São João 2, 4700-424 Braga",  41.550020296114816, -8.426517246123375),
                Contacto("+351917540440"), Horario(21,30,3,0),"pelle"))
            repository.insertCafe(Cafe(
                "28", "Caldo Entornado", 4.2F, Localizacao("R. de São João 8, 4700-325 Braga",  41.5499558792527, -8.426181515441815),
                Contacto("+351939044011"), Horario(12,30,2,0),"caldoentornado"))
            repository.insertCafe(Cafe(
                "29", "Frigideiras do Cantinho", 3.8F, Localizacao("Largo de São João do Souto 1, 4700-326 Braga",  41.550124479252766, -8.425205873112192),
                Contacto("+351253263991"), Horario(8,0,20,0),"frigideirasdocantinho"))
            repository.insertCafe(Cafe(
                "30", "Café Santa Cruz", 4.1F, Localizacao(" R. de São Marcos 130, 4700-308 Braga",  41.54974660850075, -8.4241565307826),
                Contacto("+351253262980"), Horario(7,0,0,0),"cafesantacruz"))
            repository.insertCafe(Cafe(
                "31", "Pastel de feira Braga Amor de Café", 4.6F, Localizacao("R. São Marcos N:129, 4700-328 Braga",  41.54995369614801, -8.423790657771479),
                Contacto("+351967227158"), Horario(11,0,20,0),"pasteldafeirabragaamordecafe"))
            repository.insertCafe(Cafe(
                "32", "Pastelaria Doce Praça", 3.8F, Localizacao("Av. da Liberdade 708, 4710-229 Braga",  41.54947702069276, -8.420515373112234),
                Contacto("+351253682095"), Horario(6,30,20,30),"pastelariadocepraca"))
            repository.insertCafe(Cafe(
                "33", "Pastelaria Délice", 4.5F, Localizacao("R. do Raio 292, 4710-229 Braga",  41.54953964998008, -8.420723530782602),
                Contacto("+351253271303"), Horario(7,30,18,30),"pastelariadalice"))
            repository.insertCafe(Cafe(
                "34", "Negrita", 4.0F, Localizacao("Av. Central 171, 4710-230 Braga",  41.55175965025562, -8.418980630782555),
                Contacto("+351253214831"), Horario(9,0,19,0),"negrita"))
            repository.insertCafe(Cafe(
                "35", "Café reticências", 3.8F, Localizacao("Av. 31 de Janeiro 631, 4710-926 Braga",  41.551316492099666, -8.417280159617762),
                Contacto("+351253279671"), Horario(8,0,22,30),"cafereticencias"))
            repository.insertCafe(Cafe(
                "36", "Moscada Braga", 4.1F, Localizacao("Largo Sra. A. Branca 49, 4710-443 Braga",  41.55217196609585, -8.417031590299244),
                Contacto("+351939127414"), Horario(10,0,22,30),"moscadabraga"))
            repository.insertCafe(Cafe(
                "37", "Café Chave D'Ouro", 4.6F, Localizacao("R. Beato Miguel de Carvalho 216, 4710-356 Braga",  41.55080222102201, -8.414933515441826),
                Contacto("+351253264227"), Horario(8,0,2,0),"cafechavedouro"))
            repository.insertCafe(Cafe(
                "38", "Sàbiá Pastelaria", 4.2F, Localizacao("R. Beato Miguel de Carvalho 154, 4710-428 Braga",  41.550965091968706, -8.414525873112227),
                Contacto("+351253262616"), Horario(8,0,18,0),"sabiapastelaria"))
            repository.insertCafe(Cafe(
                "39", "Casa Bolas de Berlim", 4.4F, Localizacao("R. de São Victor 190, 4710-406 Braga",  41.55255039255921, -8.41280621544175),
                Contacto("+351253296925"), Horario(7,30,20,0),"casabolasdeberlim"))
            repository.insertCafe(Cafe(
                "40", "São João", 4.0F, Localizacao("Av. da Liberdade 205, Braga",  41.54556303892525, -8.419868920223488),
                Contacto("+351253263802"), Horario(7,30,20,0),"saojoao"))
            repository.insertCafe(Cafe(
                "41", "Pastelaria Bel-Prazer 1", 4.6F, Localizacao("Praça Araújo Carandá 129, 4715-002 Braga",  41.54630414957869, -8.417840115441965),
                Contacto("+351253042971"), Horario(8,0,19,0),"pastelariabelprazer"))
            repository.insertCafe(Cafe(
                "42", "Caffe Ferrari", 4.5F, Localizacao("N585 R/C, Av. João XXI, Braga",  41.54757852022139, -8.41660351544186),
                Contacto("+351253682165"), Horario(8,0,19,0),"caffeferrari"))
            repository.insertCafe(Cafe(
                "43", "Dona Beer", 4.5F, Localizacao("R. 25 de Abril 356 R/c, 4710-914 Braga",  41.54817693813987, -8.419579573112214),
                Contacto("+351965788377"), Horario(17,0,0,0),"donabeer"))
        }
    }
}