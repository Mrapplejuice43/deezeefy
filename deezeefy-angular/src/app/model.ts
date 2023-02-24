export abstract class Compte {

    id: number;
    version: number;
    type:string;
    email:string;
    login:string;
    password:string;
    nom:string;
    prenom:string;
    pseudo:string; 
    biographie:string;
    
    constructor(id?:number, version?: number , type?: string, nom?: string, prenom?: string, email? :string,login?:string,password?:string,pseudo?:string, biographie?:string ) {
        this.id = id;
        this.version = version;
        this.login = login;
        this.password = password;
    }
}

export class Admin extends Compte {
 
    constructor(id?:number, version?: number, type?: string, nom?: string, prenom?: string, email? :string,login?:string,password?:string,pseudo?:string, biographie?:string) {
        super();

    }
}

export abstract class Contenu {
    id:number;
    version:number;
    titre:string;
    duree:number;

    constructor(id?:number, version?:number, titre?:string, duree?:number ){
        this.id=id;
        this.version=version;
        this.titre=titre;
        this.duree=duree;
    }
}
    export class Musique extends Contenu {
       
        genre:string;
    
        constructor(id?:number, version?:number, titre?:string, duree?:number, genre?:string ){
            super(id, version,titre,duree);
           this.genre=genre;
        }
    }
