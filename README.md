#TEssentials
##Download: <a href="http://speedy.sh/nG7My/TEssentials.jar">LINK</a>
###O co chodzi w tym pluginie?
**TEssentials** to prosty plugin typu Essentials. Znajdziesz w nim duzo funkcji administracyjnych i dla graczy!

==========
###Domyślny config:

```
# [------------------------------]
# [    tEssentials v0.3 ALPHA
# [------------------------------]

# [------------------------------]
# [      Podstawowe rzeczy 
# [------------------------------]
# Czy ma być włączone szczegółowe debugowanie (szczegółowe informacje wysyłane do konsoli)
debug: true
# Czy opcje wymagające pluginu BarAPI mają być włączone
barapi: true
# Główne serwerowe motd
server-motd: '&cNaszHc!'
 
# [------------------------------]
# [            Chat 
# [------------------------------]
# Format chatu
chat-format: '&8[{PREFIX}&8] &f{PLAYER}&8: &7{MESSAGE}'
# Wiadomość wyłączania chatu
chat-off: '&2Chat zostal wylaczony przez &c{PLAYER}&2!'
# Wiadomość włączania chatu
chat-on: '&2Chat zostal wlaczony przez &c{PLAYER}&2!'
# Wiadomość czyszczenia chatu
chat-clear: '&2Chat zostal wyczyszczony przez &c{PLAYER}&2!'
# Czy ma być włączona blokada URL ( - BETA!)
url-block: true
# Czy ma być włączona blokada IP ( - BETA!)
ip-block: true
# Czy ma być włączona blokada przekleństw i nazw popularnych serwerów 
words-block: true

# [------------------------------]
# [           Helpop
# [------------------------------]
# Co ile sekund można wysyłać /helpop 
helpop-delay: 10
# Format helpopu
helpop-format: '&8[&4Helpop&8] &7{PLAYER}: &c{MESSAGE}'

# [------------------------------]
# [           ChangeItem
# [------------------------------]
# Czym ma sie usuwac nazwe itemu lub opis
changeitem-remove: '-remove'

# [------------------------------]
# [         Join/Leave
# [------------------------------]
# Format dolaczania na serwer (zostaw '' jezeli chcesz wylaczyc)
join-format: ''
# Format opuszczania serwera (zostaw '' jezeli chcesz wylaczyc)
leave-format: ''

# [------------------------------]
# [         Teleportation
# [------------------------------]
# Swiat w którym znajduje się spawn
spawn-world: 'world'
# Okres oczekiwania na teleport (w sekundach)
tp-delay: 10
  
# [------------------------------]
# [          ClearItems
# [------------------------------]
# Swiat który ma być wyczyszczony
clear-world: 'world'


# Druga wiadomość, już po wyczyszczeniu
clear-cleared: '&8[&cClearItems&8] &7Wyczyszczono wszystkie przedmioty lezace na ziemi!'

# Ile sekund po ostrzeżeniu ma być czyszczony serwer
clear-delay-1: 30

# Co ile sekund ma być wykonywane czyszczenie itemów
clear-delay-2: 700
```

=========
###Komendy:
- **/treload** - Przeladowanie pluginu.
- **/helpop <tekst>** - Szybki kontakt z administracja. 
- **/help** - Spis twoich komend.
- **/enchant <enchant> <level>** - Enchantowanie przedmiotow.
- **/ci** - Czyszczenie ekwipunku.
- **/changename <tekst>** - Zmiana nazwa przedmiotu.
- **/changelore <tekst>** - Zmiana opisu przedmiotu. 
- **/head <nick>** - Daje do ekwipunku glowe danego gracza.
- **/back** - Powrot do poprzedniej lokalizacji.
- **/gamemode <tryb>** - Zmiana trybu gry.
- **/time <day/night>** - Zmiana czasu gry.
- **/weather <thunder/sun>** - Zmiana pogodu gry. 
- **/tp <nick/all> <nick2>** - Teleportacja pomiedzy graczami.
- **/whois <nick>** - Informacje o danym graczu.
- **/heal** - Leczenie.
- **/tppos [nick] <x> <y> <z>** - Teleportacja na dane koordynaty.
- **/invsee <nick>** - Podgladanie ekwipunku gracza. 
- **/setspawn** - Ustawia globalny spawn.
- **/spawn** - Teleportacja na spawn.
- **/msg <nick> <wiadomosc>** - Prywatna wiadomosc.
- **/reply <tekst>** - Odpowiedz na prywatna wiadomosc [ULATWIENIE]. 
- **/chat <off/on/clear>** - Manipulacja chatem.
- **/fly <on/off> <nick>** - Wlaczanie lub wylaczanie chatu.
- **/world <swiat>** - Teleportacja pomiedzy swiatami.
