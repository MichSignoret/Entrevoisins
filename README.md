# OpenClassrooms
Pour générer l'APK de l'application Entrevoisins :
Ouvrez le menu Build dans la barre d'outils et sélectionnez Generate Signed Bundle/APK.
Cochez le bouton radio APK et passez à la fenêtre suivante.
Si vous n'avez pas de KeyStore, vous devez en créer une. Pour ce, cliquez sur Create New.

Création de KeyStore
Dans la nouvelle fenêtre, entrez le chemin de votre nouveau KeyStore, puis entrez un mot de passe pour le protéger.
Dans la même fenêtre, vous définirez également une nouvelle clé pour votre application. 
Entrez un nom pour votre clé dans le champ d'alias, puis entrez un mot de passe pour celle-ci.
La validité par défaut d'une clé est de 25 ans. Vous pouvez la changer dans le champ Valididy.
Vous n'êtes pas obligé de remplir tous les détails du certificat, 
choisissez simplement ceux qui, selon vous, devraient figurer dessus.
Une fois que vous avez rempli les détails du certificat, sélectionnez OK . 
Vous serez ensuite redirigé vers l' écran Generate Signed Bundle/APK .

Une fois sur l'écran Generate Signed Bundle/APK, votre KeyStore et votre clé sont renseignés dans les champs
KeyStore path et KeyAlias. Vous devez saisir les mots de passe que vous avez renseigné dans l'écran de création.
Cliquez ensuite sur Next.
Vous devez ensuite choisir si la version d'APK que vous générer est une version de test (debug) ou de production (release)

Vous trouverez votre APK dans le dossier de votre application 
 - /app/debug pour la version debug
 - /app/release pour la version release
