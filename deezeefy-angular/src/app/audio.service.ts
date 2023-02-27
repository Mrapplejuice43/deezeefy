import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AudioService {
  private audioContext: AudioContext
  private bufferSource: AudioBufferSourceNode
  private gainNode: GainNode
  private musicStartOffset: number = 0

  gainValue: number = 1;

  constructor() {  }

  private init() {
    this.audioContext = new AudioContext()
    this.gainNode = this.audioContext.createGain()
    this.gainNode.gain.value = this.gainValue;
    this.gainNode.connect(this.audioContext.destination)
  }

  sendToBufferAndPlay(view: Int8Array) {
    // Pour l'autoplay on créée l'audio context uniquement lors de le première interation avec la page
    if(!this.audioContext) {this.init()}

    this.audioContext.decodeAudioData(view.buffer, (soundBuffer) => {
      // On vérifie si il y a déja un buffer et on le stop pour na pas avoir plusieurs musiques en même temps
      if(this.bufferSource) {
        this.stop()
      }
      this.bufferSource = this.audioContext.createBufferSource()
      this.bufferSource.connect(this.gainNode)
      this.bufferSource.buffer = soundBuffer
      this.play()
    })
  }

  play() {
    this.bufferSource.start(0, this.musicStartOffset)
  }

  stop () {
    this.bufferSource.stop(0)
  }
}
