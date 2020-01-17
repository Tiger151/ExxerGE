package net.exxer.game.entities.tiles;


import net.exxer.game.gfx.Assets;

public class RockTile extends Tile{

	public RockTile(int id) {
		super(Assets.rock, id);
	}
	@Override
	public boolean isSolid(){
		return true;
	}
}
